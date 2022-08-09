package com.desafiofinal.praticafinal.modelEntity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyerId;

    private String buyerName;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.REFRESH)
    private List<Cart> cartList;
}
