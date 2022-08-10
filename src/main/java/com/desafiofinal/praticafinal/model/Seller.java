package com.desafiofinal.praticafinal.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"productList"})

public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sellerName;

    @OneToMany(mappedBy ="seller", cascade = CascadeType.REFRESH)
    private List<Product> productList;
}
