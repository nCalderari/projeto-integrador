package com.desafiofinal.praticafinal.modelEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long batchId;

    private float currentTemperature;
    private float minimumTemperature;
    private long initialQuantity;
    private long currentQuantity;
    private Date manufacturingDate;
    private Date manufacturingTime;
    private Date dueDate;

    @ManyToOne
    @JoinColumn (name = "id_inboundorder")
    @JsonIgnoreProperties("batchStockList")
    private InBoundOrder inBoundOrder;

    @ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn (name = "id_product")
    private Product product;

    public long getBatchId() {
        return batchId;
    }

    public void setBatchId(long batchId) {
        this.batchId = batchId;
    }

    public float getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(float currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public float getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(float minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public long getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(long initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public long getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(long currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Date getManufacturingTime() {
        return manufacturingTime;
    }

    public void setManufacturingTime(Date manufacturingTime) {
        this.manufacturingTime = manufacturingTime;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public InBoundOrder getInBoundOrder() {
        return inBoundOrder;
    }

    public void setInBoundOrder(InBoundOrder inBoundOrder) {
        this.inBoundOrder = inBoundOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
