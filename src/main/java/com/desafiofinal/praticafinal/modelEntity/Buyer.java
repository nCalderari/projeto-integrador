package com.desafiofinal.praticafinal.modelEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyerId;

    private String buyerName;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.REFRESH)
    private List<Cart> cartList;
}
