package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.modelDto.BatchStockDto;
import com.desafiofinal.praticafinal.modelDto.CartBatchStockDto;
import com.desafiofinal.praticafinal.modelDto.CartDto;
import com.desafiofinal.praticafinal.modelEntity.*;
import com.desafiofinal.praticafinal.repository.*;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Double createPurchase(CartDto cartDto) throws Exception {

        Cart newCart = CartDto.convertDtoToCart(cartDto);
        verifyBuyer(cartDto, newCart);

        double price =0.0;
        System.out.println("o price é" + price);

        for (CartBatchStock cartBatchStock: newCart.getListCartBatchStock()){
            List<BatchStock> tempBatchList = new ArrayList<>();

            Optional<BatchStock> foundBatch = batchStockRepo.findById(cartBatchStock.getBatchStock().getBatchId());

            if(foundBatch.isPresent()){
                cartBatchStock.setBatchStock(foundBatch.get());
                tempBatchList.add(foundBatch.get());

            } else {
                throw  new Exception("Não existe o BatchStock");
            }


           // Optional<CartBatchStock> foundPrice = cartBatchStockRepo.(cartBatchStock.getPricePerProduct()) ;

            price = cartBatchStock.getPricePerProduct() * cartBatchStock.getProductQuantity();
        }

        return price;
    }

    private void verifyBuyer(CartDto cartDto, Cart cart) throws Exception {
        Optional<Buyer> foundBuyer =  buyerRepo.findById(cartDto.getBuyer());
        if(foundBuyer.isPresent()) {
            cart.setBuyer(foundBuyer.get());
        }else{
            throw new Exception(); //TODO colocar exceção ElementNotFounExists
        }
    }

    private void verifyCartBatchStock(CartDto cartDto, Cart cart) throws Exception {
        Optional<Buyer> foundBuyer =  buyerRepo.findById(cartDto.getBuyer());
        if(foundBuyer.isPresent()) {
            cart.setBuyer(foundBuyer.get());
        }else{
            throw new Exception(); //TODO colocar exceção ElementNotFounExists
        }
    }

    public List<CartBatchStockDto> getProducts(long purchaseId){
        return null;
    }
    public CartDto updateStatus(long purchaseId, String status){
        return null;
    }
}
