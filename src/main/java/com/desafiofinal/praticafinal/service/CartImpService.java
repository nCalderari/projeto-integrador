package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.modelDto.CartBatchStockDto;
import com.desafiofinal.praticafinal.modelDto.CartDto;
import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import com.desafiofinal.praticafinal.modelEntity.Cart;
import com.desafiofinal.praticafinal.modelEntity.CartBatchStock;
import com.desafiofinal.praticafinal.repository.BatchStockRepo;
import com.desafiofinal.praticafinal.repository.CartBatchStockRepo;
import com.desafiofinal.praticafinal.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartImpService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private BatchStockRepo batchStockRepo;

    @Autowired
    private CartBatchStockRepo cartBatchStockRepo;

    public Double createPurchase (CartDto cartDto) throws Exception {

        Cart newCart = CartDto.convertDtoToCart(cartDto);
        double price =0.0;


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

    public List<CartBatchStockDto> getProducts(long purchaseId){
        return null;
    }
    public CartDto updateStatus(long purchaseId, String status){
        return null;
    }
}
