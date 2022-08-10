package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTOWithSeller {
    private String productName;
    private String productType;
    private LocalDate validateDate;
    private double price;
    private Long idSeller;
    private double bulk;

    public ProductDTOWithSeller(Product product, Seller seller) {
        this.productName = product.getProductName();
        this.productType = product.getProductType();
        this.price = product.getPrice();
        this.bulk = product.getBulk();
        this.idSeller = seller.getId();
        this.validateDate = product.getValidateDate();
    }
}