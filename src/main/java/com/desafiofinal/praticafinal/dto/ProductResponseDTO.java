package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private long id;

//    private String productType;
//
//    private Date validateDate;
//
//    private double price;
//
//    private String productId;
//
//    private String productName;
//
//    private SellerDto seller;
//
//    private double bulk;

    public ProductResponseDTO(Product product){
        this.id = product.getId();
//        this.productType = product.getProductType();
//        this.validateDate = product.getValidateDate();
//        this.price = product.getPrice();
//        this.productId = product.getProductId();
//        this.productName = product.getProductName();
//        this.seller = new SellerDto(product.getSeller());
//        this.bulk = product.getBulk();
    }
}