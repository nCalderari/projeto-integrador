package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private long id;

    private String productType;

    private LocalDate validateDate;

    private double price;

    private String productId;

    private String productName;


    private Seller seller;

    private double bulk;

    @JsonIgnore
    private List<BatchStock> batchList;

    public ProductDto(Product product){
        this.id = product.getId();
        this.productType = product.getProductType();
        this.validateDate = product.getValidateDate();
        this.price = product.getPrice();
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.seller = product.getSeller();
        this.bulk = product.getBulk();
        this.batchList = product.getBatchList();

    }

    public static Product convertDtoToProduct (ProductDto productDto){
        return Product.builder()
                .productType(productDto.getProductType())
                .validateDate(productDto.getValidateDate())
                .price(productDto.getPrice())
                .productName(productDto.getProductName())
                .seller(productDto.getSeller())
                .build();
    }

}
