package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import com.desafiofinal.praticafinal.modelEntity.Product;
import com.desafiofinal.praticafinal.modelEntity.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private long id;

    private String productType;

    private Date validateDate;

    private double price;

    private String productId;

    private String productName;


    private Seller seller;

    private double bulk;


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
}
