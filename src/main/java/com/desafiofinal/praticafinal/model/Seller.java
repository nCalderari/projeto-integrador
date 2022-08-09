package com.desafiofinal.praticafinal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSeller;
    private String sellerName;

    @OneToMany(mappedBy ="seller", cascade = CascadeType.REFRESH)
    private List<Product> productList;
}
