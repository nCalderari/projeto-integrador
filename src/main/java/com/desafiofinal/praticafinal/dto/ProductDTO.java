package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String productName;
    private String productType;
    private double price;
    private Long sellerId;
    private double bulk;

    public ProductDTO(Product product) {
        this.productName = product.getProductName();
        this.productType = product.getProductType();
        this.price = product.getPrice();
        this.bulk = product.getBulk();
    }

    public Product toModel() {
        return new Product(this.productName, this.price, this.sellerId);
    }

}
