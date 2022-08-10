package com.desafiofinal.praticafinal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String productType;

    private LocalDate validateDate;

    private double price;

    private String productId;

    private String productName;

    @ManyToOne (cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_seller")
    private Seller seller;

    private double bulk;

    @OneToMany (mappedBy = "product", cascade = CascadeType.REFRESH)
    @JsonIgnoreProperties("product")
    private List<BatchStock> batchList;

}
