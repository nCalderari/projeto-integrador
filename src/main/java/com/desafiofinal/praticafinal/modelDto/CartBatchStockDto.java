package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import com.desafiofinal.praticafinal.modelEntity.Cart;
import com.desafiofinal.praticafinal.modelEntity.CartBatchStock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartBatchStockDto {

    private int CartBatchStockId;


    private CartDto idCart;

    private BatchStockDto idBatchStock;

    private double pricePerProduct;

    private int productQuantity;

    public CartBatchStockDto (CartBatchStock cartBatchStock){
        this.CartBatchStockId=cartBatchStock.getCartBatchStockId();
        this.idCart=new CartDto(cartBatchStock.getIdCart());
        this.idBatchStock= new BatchStockDto(cartBatchStock.getIdBatchStock());
        this.pricePerProduct=cartBatchStock.getPricePerProduct();
        this.productQuantity=cartBatchStock.getProductQuantity();
    }

    public static CartBatchStock convertDtoToCartBatchStock (CartBatchStockDto cartBatchStockDto){
        return CartBatchStock.builder()
                .idCart(CartDto.convertDtoToCart(cartBatchStockDto.getIdCart()))
           //     .idBatchStock(BatchStockDto.)
                .build();
    }
}
