package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Purchase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {

    private long CartBatchStockId;

    private long cart;

    private long batchStock;

    private double pricePerProduct;

    private int productQuantity;

    public PurchaseDTO(Purchase purchase){
        this.CartBatchStockId= purchase.getCartBatchStockId();
//        this.idCart=new CartDto(purchase.getIdCart());
//        this.batchStock= new BatchStockDto(purchase.getBatchStock());
        this.pricePerProduct= purchase.getPricePerProduct();
        this.productQuantity= purchase.getProductQuantity();
    }

    public static Purchase convertDtoToCartBatchStock (PurchaseDTO purchaseDTO){
        return Purchase.builder()
//                .idCart(CartDto.convertDtoToCart(purchaseDTO.getIdCart()))
//                .batchStock(BatchStockDto.convertBatchStockDtoToBatchStock(purchaseDTO.getBatchStock()))

                .build();
    }
}
