package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTOwithID {

    private long id;

    public ProductResponseDTOwithID(Product product){
        this.id = product.getId();
    }
}
