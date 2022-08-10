package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDto {

    private long sellerId;
    private String sellerName;
    private List<Product> productList;

    public SellerDto(Seller seller) {
        this.sellerId = seller.getSellerId();
        this.sellerName = seller.getSellerName();
        this.productList = seller.getProductList();
    }
}
