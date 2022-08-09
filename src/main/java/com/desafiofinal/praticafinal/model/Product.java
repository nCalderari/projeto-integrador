package com.desafiofinal.praticafinal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productType;

    private Date validateDate;

    private double price;

    private String productId;

    private String productName;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_seller")
    private Seller seller;

    private double bulk;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REFRESH)
    private List<BatchStock> batchList;

    public Product(String productName, double price, Long sellerId) {
    }
}
