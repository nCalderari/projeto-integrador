package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.Cart;
import com.desafiofinal.praticafinal.model.CartBatchStock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartBatchStockDto {

    private long CartBatchStockId;

    private CartDto cart;

    private BatchStockDTO batchStock;

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
//                .idCart(CartDto.convertDtoToCart(cartBatchStockDto.getCart()))
                .pricePerProduct(cartBatchStockDto.pricePerProduct)
                .productQuantity(cartBatchStockDto.getProductQuantity())
                .batchStock(BatchStockDTO.convertBatchStockDtoToBatchStockIdOnly(cartBatchStockDto.getBatchStock()))
                .build();
    }

    public static List<CartBatchStock> convertToListEntity(List<CartBatchStockDto> cartBatchStockDtoList){
        return cartBatchStockDtoList.stream()
                .map(CartBatchStockDto::convertDtoToCartBatchStock)
                .collect(Collectors.toList());
    }

}
