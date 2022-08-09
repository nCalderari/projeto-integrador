package com.desafiofinal.praticafinal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productType;

    private Date validateDate;

    private double price;

    private String productId;

    private String productName;

    @ManyToOne (cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_seller")
    private Seller seller;

    private double bulk;

    @OneToMany (mappedBy = "product", cascade = CascadeType.REFRESH)
    private List<BatchStock> batchList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(Date validateDate) {
        this.validateDate = validateDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public double getBulk() {
        return bulk;
    }

    public void setBulk(double bulk) {
        this.bulk = bulk;
    }

    public List<BatchStock> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<BatchStock> batchList) {
        this.batchList = batchList;
    }
}
