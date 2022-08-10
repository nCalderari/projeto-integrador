package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDto {

    private long idSeller;
    private String sellerName;

    public SellerDto(Seller seller) {
        this.idSeller = seller.getIdSeller();
        this.sellerName = seller.getSellerName();
    }
}
