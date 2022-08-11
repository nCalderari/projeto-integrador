package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.exception.ElementeAlreadyExistsException;
import com.desafiofinal.praticafinal.exception.ExceededCapacityException;
import com.desafiofinal.praticafinal.model.*;
import com.desafiofinal.praticafinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartImpService implements ICartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private IBatchStockRepo batchStockRepo;

    @Autowired
    private CartBatchStockRepo cartBatchStockRepo;

    @Autowired
    private BuyerRepo buyerRepo;

    @Autowired
    private IProductRepo productRepo;

    @Autowired
    private ISectorRepo sectorRepo;

    @Transactional
    @Override
    public Double createPurchase(Cart cart){

        Buyer foundBuyer = verifyBuyer(cart.getBuyer());
        cart.setBuyer(foundBuyer);

        List<CartBatchStock> foundCartBatchStockList = verifyCartBatchStock(cart.getListCartBatchStock());
        cart.setListCartBatchStock(foundCartBatchStockList);

        double totalPrice = getTotalPrice(cart);
        cart.setOrderStatus("Open");
        cart.setTotalPrice(totalPrice);
        cartRepo.save(cart);
        cartBatchStockRepo.saveAll(cart.getListCartBatchStock());

        return totalPrice;
    }

    @Override
    public List<BatchStock> getProducts(long purchaseId){ //purchase = cartId
        Optional <Cart> foundCart = cartRepo.findById(purchaseId);
        List<BatchStock> batchStockList = new ArrayList<>();

        for (CartBatchStock cartBatchStock : foundCart.get().getListCartBatchStock()){
            BatchStock foundBatchStock = cartBatchStock.getBatchStock();
            batchStockList.add(foundBatchStock);
        }
        return batchStockList;
    }

    @Override
    public String updateStatus(long purchaseId){
        Optional<Cart> foundCart = verifyIfCartExists(purchaseId);
        foundCart.get().setOrderStatus("Finished");
        cartRepo.save(foundCart.get());
        return "Order completed successfully";
    }

    private double getTotalPrice(Cart cart) {
        double totalPrice = 0d;
        for (CartBatchStock cartBatchStock : cart.getListCartBatchStock()) {
                double price = cartBatchStock.getPricePerProduct() * cartBatchStock.getProductQuantity();
                totalPrice += price;
        }
        return totalPrice;
    }

    private Buyer verifyBuyer(Buyer buyer) {
        Optional<Buyer> foundBuyer =  buyerRepo.findById(buyer.getBuyerId());
        if(foundBuyer.isPresent()) {
            return foundBuyer.get();
        }else{
            throw new ElementNotFoundException("Buyer does not exists");
        }
    }

    private List<CartBatchStock> verifyCartBatchStock(List<CartBatchStock> cartBatchStockList)  {
        List<CartBatchStock> cartBatchStockListVerified = new ArrayList<>();
        for(CartBatchStock cbs : cartBatchStockList) {
            BatchStock foundBatchStock = verifyBatchStock(cbs.getBatchStock());
            cbs.setBatchStock(foundBatchStock);
            cartBatchStockListVerified.add(cbs);
        }
       return cartBatchStockListVerified;
    }


    private BatchStock verifyBatchStock(BatchStock batchStock) {
        Optional<BatchStock> foundBatchStock = batchStockRepo.findById(batchStock.getBatchId());
        if (foundBatchStock.isPresent()) {
            return foundBatchStock.get();
        } else {
            throw new ElementNotFoundException("Batch stock does not exist");
        }
    }

    private Optional<Cart> verifyIfCartExists(long purchaseId) {
        Optional <Cart> foundCart = cartRepo.findById(purchaseId);
        List<BatchStock> batchStockList = new ArrayList<>();

        if(foundCart.isEmpty()){
            throw new ElementNotFoundException("Cart does not exist");
        }else{
            verifyStatus(foundCart, batchStockList);
        }
        return foundCart;
    }

    private void verifyStatus(Optional<Cart> foundCart, List<BatchStock> batchStockList) {
        String cartStatus = foundCart.get().getOrderStatus();
        if(cartStatus.equalsIgnoreCase("Open")){
            verifyQuantity(foundCart, batchStockList);
        } else {
            throw new ElementeAlreadyExistsException("Cart already finished");
        }
    }

    private void verifyQuantity(Optional<Cart> foundCart, List<BatchStock> batchStockList)  {
        for (CartBatchStock cartBatchStock : foundCart.get().getListCartBatchStock()){
            BatchStock foundBatchStock = cartBatchStock.getBatchStock();
                batchStockList.add(foundBatchStock);
                long cartQuantity= cartBatchStock.getProductQuantity();
                if(cartBatchStock.getProductQuantity()<=foundBatchStock.getCurrentQuantity()){
                    verifyCapacity(foundBatchStock, cartQuantity);
                }else{
                    throw new ExceededCapacityException("Quantity unavailable");
                }
        }
    }

    private void verifyCapacity(BatchStock foundBatchStock, long cartQuantity) {
        long stockQuantity = foundBatchStock.getCurrentQuantity();
        long newQuantity = stockQuantity - cartQuantity;
        double totalItemsVolume = foundBatchStock.getProduct().getBulk()*cartQuantity;
        double increaseCapacity = foundBatchStock.getInBoundOrder().getSector().getCapacity()+ totalItemsVolume;
        double maxCapacity = foundBatchStock.getInBoundOrder().getSector().getMaxCapacity();

        if (increaseCapacity<=maxCapacity){
            foundBatchStock.getInBoundOrder().getSector().setCapacity(increaseCapacity);
            foundBatchStock.setCurrentQuantity(newQuantity);

            batchStockRepo.save(foundBatchStock);
            sectorRepo.save(foundBatchStock.getInBoundOrder().getSector());

        } else {
            throw new ExceededCapacityException("Maximum capacity has been exceeded");
        }
    }

}

//3, 4 e 5: escrever query nativa no repository e já trazer o objeto pronto