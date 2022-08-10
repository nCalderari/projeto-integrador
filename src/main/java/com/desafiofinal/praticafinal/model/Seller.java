package com.desafiofinal.praticafinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.lang.Nullable;
import java.util.Set;

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

    @OneToMany(mappedBy ="seller")
    @JsonIgnore
    private Set<Product> productList;

    public Seller(String sellerName) {
        this.sellerName = sellerName;
    }
}
