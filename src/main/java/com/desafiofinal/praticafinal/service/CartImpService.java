package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.modelDto.CartBatchStockDto;
import com.desafiofinal.praticafinal.modelDto.CartDto;
import com.desafiofinal.praticafinal.modelEntity.*;
import com.desafiofinal.praticafinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
            CartBatchStock newCartBatchStock = new CartBatchStock();
            newCartBatchStock.setCartBatchStockId(dto.getCartBatchStockId());
            newCartBatchStock.setIdCart(cart);
            newCartBatchStock.setPricePerProduct(dto.getPricePerProduct());
            newCartBatchStock.setBatchStock(batchStock);
            newCartBatchStock.setProductQuantity(dto.getProductQuantity());
            return newCartBatchStock;


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

    public List<CartBatchStockDto> getProducts(long purchaseId){
        return null;
    }
    public CartDto updateStatus(long purchaseId, String status){
        return null;
    }
}
