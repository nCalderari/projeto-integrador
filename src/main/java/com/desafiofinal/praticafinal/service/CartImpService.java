package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.CartBatchStockDto;
import com.desafiofinal.praticafinal.dto.CartDto;
import com.desafiofinal.praticafinal.model.*;
import com.desafiofinal.praticafinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartImpService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private BatchStockRepo batchStockRepo;

    @Autowired
    private CartBatchStockRepo cartBatchStockRepo;

    @Autowired
    private BuyerRepo buyerRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SectorRepo sectorRepo;

    @Transactional
    public Double createPurchase(CartDto cartDto) {

        Cart newCart = foundCart(cartDto.getCartId());
        newCart.setDate(cartDto.getDate());
        newCart.setOrderStatus(cartDto.getOrderStatus());
        verifyBuyer(cartDto, newCart);
        List<CartBatchStock> cartBatchStockList = convertToCartBatchStock(cartDto, newCart);
        newCart.setListCartBatchStock(cartBatchStockList);

        double totalPrice = 0d;
        for (CartBatchStock c : newCart.getListCartBatchStock()) {
            double price = getTotalPrice(c);
            totalPrice += price;
        }

        newCart.setTotalPrice(totalPrice);
        cartRepo.save(newCart);
        cartBatchStockRepo.saveAll(cartBatchStockList);

        return totalPrice;
    }

    private void verifyBuyer(CartDto cartDto, Cart cart) {
        Optional<Buyer> foundBuyer =  buyerRepo.findById(cartDto.getBuyer());
        if(foundBuyer.isPresent()) {
            cart.setBuyer(foundBuyer.get());
        }else{
            throw new RuntimeException("Buyer does not exists"); //TODO colocar exceção ElementNotFounExists
        }
    }

    private List<CartBatchStock> convertToCartBatchStock(CartDto cartDto, Cart cart)  {

        return cartDto.getListCartBatchStock().stream().map(dto -> {
            BatchStock batchStock = foundBatchStock(dto);
            return new CartBatchStock(
                    dto.getCartBatchStockId(),
                    cart,
                    batchStock,
                    dto.getPricePerProduct(),
                    dto.getProductQuantity());


        }).collect(Collectors.toList());
    }

    private double getTotalPrice(CartBatchStock cartBatchStock){
       return cartBatchStock.getPricePerProduct() * cartBatchStock.getProductQuantity();
    }

    private BatchStock foundBatchStock(CartBatchStockDto cartBatchStockDto) {
        Optional<BatchStock> batchStock = batchStockRepo.findById(cartBatchStockDto.getBatchStock());
        if (batchStock.isPresent()) {
            return batchStock.get();
        } else {
            throw new RuntimeException("Batch stock does not exist");
        }
    }

    private Cart foundCart(long id) {
        Cart cart = new Cart();
        Optional<Cart> foundCart = cartRepo.findById(id);
        if(foundCart.isPresent()){
            cart.setCartId(foundCart.get().getCartId());
        } else {
            cart.setCartId(0L);
        }
        return cart;
    }

    public List<BatchStock> getProducts(long purchaseId){ //purchase = cartId
       Optional <Cart> foundCart = cartRepo.findById(purchaseId);
       List<BatchStock> batchStockList = new ArrayList<>();

       for (CartBatchStock cartBatchStock : foundCart.get().getListCartBatchStock()){
               BatchStock foundBatchStock = cartBatchStock.getBatchStock();
               batchStockList.add(foundBatchStock);
       }

        return batchStockList;
    }
    public String updateStatus(long purchaseId) throws Exception {
        Optional <Cart> foundCart = cartRepo.findById(purchaseId);
        List<BatchStock> batchStockList = new ArrayList<>();

        if(foundCart.isEmpty()){
            throw new Exception("Cart does not exist");
        }else{
            String cartStatus = foundCart.get().getOrderStatus();

            if(cartStatus.equalsIgnoreCase("Aberto")){

                for (CartBatchStock cartBatchStock : foundCart.get().getListCartBatchStock()){
                    BatchStock foundBatchStock = cartBatchStock.getBatchStock();
                    batchStockList.add(foundBatchStock);
                    long cartQuantity= cartBatchStock.getProductQuantity();
                    long stockQuantity = foundBatchStock.getCurrentQuantity();
                    double totalItemsVolume = foundBatchStock.getProduct().getBulk()*cartQuantity;

                    if(cartQuantity<=stockQuantity){
                        long newQuantity = stockQuantity - cartQuantity;
                        double increaseCapacity = foundBatchStock.getInBoundOrder().getSector().getCapacity()+totalItemsVolume;

                        if (increaseCapacity<=100000){ // TODO criar max capacity no banco

                            foundBatchStock.getInBoundOrder().getSector().setCapacity(increaseCapacity);
                            foundBatchStock.setCurrentQuantity(newQuantity);

                            batchStockRepo.save(foundBatchStock);
                            sectorRepo.save(foundBatchStock.getInBoundOrder().getSector());

                        } else {
                            throw new Exception("A capacidade máxima foi superada");
                        }
                    }else{
                        throw new Exception("Quantidade indisponível");
                    }
                }
            } else {
                throw new Exception("Carrinho já finalizado");
            }

        }

        foundCart.get().setOrderStatus("Finalizado");
        cartRepo.save(foundCart.get());
        return "Pedido finalizado com sucesso";
    }
}
