package com.desafiofinal.praticafinal.Builder;

import java.util.ArrayList;
import java.util.List;

import com.desafiofinal.praticafinal.model.CartBatchStock;

public class CartBatchStockBuilder {
    
    private CartBatchStock cartBatchStock;

    private CartBatchStockBuilder(){}

    public static CartBatchStockBuilder aCartBatchStockBuilder() {

        CartBatchStockBuilder builder = new CartBatchStockBuilder(); 
         
        builder.cartBatchStock.setBatchStock(BatchStockBuilder.aBatchStock().create());
        builder.cartBatchStock.setPricePerProduct(5.50);
        builder.cartBatchStock.setProductQuantity(20);

        return builder;

    }

    public static List<CartBatchStock> aListOfCartBatchStocks() {
        ArrayList<CartBatchStock> cartBatchStockList = new ArrayList<>();

        cartBatchStockList.add(aCartBatchStockBuilder().create());

        return cartBatchStockList;
    }
    
    public CartBatchStock create() {
        return cartBatchStock;
    }
}
