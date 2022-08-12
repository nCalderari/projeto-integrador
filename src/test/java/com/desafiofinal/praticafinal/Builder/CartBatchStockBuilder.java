package com.desafiofinal.praticafinal.Builder;

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

    public CartBatchStock create() {
        return cartBatchStock;
    }
}
