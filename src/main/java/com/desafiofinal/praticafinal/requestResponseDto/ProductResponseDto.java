package com.desafiofinal.praticafinal.requestResponseDto;

import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private long id;

    private String productType;

    private LocalDate validateDate;

    private double price;

    private String productId;

    private String productName;

    private Seller seller;

    private double bulk;


    public ProductResponseDto(Product product){
        this.id = product.getId();
        this.productType = product.getProductType();
        this.validateDate = product.getValidateDate();
        this.price = product.getPrice();
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.seller = product.getSeller();
        this.bulk = product.getBulk();


    }

    public static Product convertDtoToProduct (ProductResponseDto productDto){
        return Product.builder()
                .productType(productDto.getProductType())
                .validateDate(productDto.getValidateDate())
                .price(productDto.getPrice())
                .productName(productDto.getProductName())
                .seller(productDto.getSeller())
                .build();
    }

}
