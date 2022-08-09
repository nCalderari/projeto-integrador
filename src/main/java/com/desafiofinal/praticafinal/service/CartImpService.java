package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.modelDto.CartBatchStockDto;
import com.desafiofinal.praticafinal.modelDto.CartDto;
import com.desafiofinal.praticafinal.modelEntity.Cart;
import com.desafiofinal.praticafinal.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartImpService {

    @Autowired
    private CartRepository cartRepository;

    public Double createPurchase (CartDto cartDto){

        //Cart newCart =

        return null;
    }

    public List<CartBatchStockDto> getProducts(long purchaseId){
        return null;
    }
    public CartDto updateStatus(long purchaseId, String status){
        return null;
    }
}
