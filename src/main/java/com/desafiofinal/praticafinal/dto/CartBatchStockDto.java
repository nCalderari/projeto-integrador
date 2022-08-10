package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.CartBatchStock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartBatchStockDto {

    private long CartBatchStockId;

    private long cart;

    private long batchStock;

    private double pricePerProduct;

    private int productQuantity;

    public CartBatchStockDto (CartBatchStock cartBatchStock){
        this.CartBatchStockId=cartBatchStock.getCartBatchStockId();
//        this.idCart=new CartDto(cartBatchStock.getIdCart());
//        this.batchStock= new BatchStockDto(cartBatchStock.getBatchStock());
        this.pricePerProduct=cartBatchStock.getPricePerProduct();
        this.productQuantity=cartBatchStock.getProductQuantity();
    }

    public static CartBatchStock convertDtoToCartBatchStock (CartBatchStockDto cartBatchStockDto){
        return CartBatchStock.builder()
//                .idCart(CartDto.convertDtoToCart(cartBatchStockDto.getIdCart()))
//                .batchStock(BatchStockDto.convertBatchStockDtoToBatchStock(cartBatchStockDto.getBatchStock()))

                .build();
    }
}
