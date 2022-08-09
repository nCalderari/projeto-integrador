package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.Product;
import com.desafiofinal.praticafinal.modelEntity.Seller;
import com.desafiofinal.praticafinal.modelEntity.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


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
