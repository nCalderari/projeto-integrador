package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import com.desafiofinal.praticafinal.modelEntity.Cart;
import com.desafiofinal.praticafinal.modelEntity.CartBatchStock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartBatchStockDto {

    private int CartBatchStockId;

    private CartDto idCart;

    private long batchStock;

    private double pricePerProduct;

    private int productQuantity;

    public CartBatchStockDto (CartBatchStock cartBatchStock){
        this.CartBatchStockId=cartBatchStock.getCartBatchStockId();
        this.idCart=new CartDto(cartBatchStock.getIdCart());
//        this.batchStock= new BatchStockDto(cartBatchStock.getBatchStock());
        this.pricePerProduct=cartBatchStock.getPricePerProduct();
        this.productQuantity=cartBatchStock.getProductQuantity();
    }

    public static CartBatchStock convertDtoToCartBatchStock (CartBatchStockDto cartBatchStockDto){
        return CartBatchStock.builder()
                .idCart(CartDto.convertDtoToCart(cartBatchStockDto.getIdCart()))
                .batchStock(BatchStockDto.convertBatchStockDtoToBatchStock(cartBatchStockDto.getBatchStock()))
                .build();
    }
}
