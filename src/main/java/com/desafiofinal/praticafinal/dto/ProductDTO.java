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
    private Seller seller;
    private double bulk;

    public ProductDTO(Product product) {
        this.productName = product.getProductName();
        this.productType = product.getProductType();
        this.price = product.getPrice();
        this.seller = product.getSeller();
        this.bulk = product.getBulk();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public double getBulk() {
        return bulk;
    }

    public void setBulk(double bulk) {
        this.bulk = bulk;
    }


}
