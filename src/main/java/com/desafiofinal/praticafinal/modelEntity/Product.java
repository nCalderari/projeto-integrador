package com.desafiofinal.praticafinal.modelEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Product {
    @Id
    private long id;

    private String productType;

    private Date validateDate;

    private double price;

    private String productId;

    private String productName;

    //private Seller sellerId;

    private double bulk;



}
