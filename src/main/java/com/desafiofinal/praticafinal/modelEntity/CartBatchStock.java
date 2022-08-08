package com.desafiofinal.praticafinal.modelEntity;

import javax.persistence.*;

@Entity
public class CartBatchStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CartBatchStockId;

    @ManyToOne
    @JoinColumn(name = "id_cart")
    private Cart idCart;

    @ManyToOne
    @JoinColumn(name = "id_batchStock")
    private BatchStock idBatchStock;

    private double pricePerProduct;

    private int productQuantity;
}
