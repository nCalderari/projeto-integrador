package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.BatchStock;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BatchStockDTO {


    private long batchNumber;

    @Nullable
    private long product;

    private float currentTemperature;

    private float minimumTemperature;

    private long initialQuantity;

    private long currentQuantity;

    private Date manufacturingDate;

    private Date manufacturingTime;

    private Date dueDate;


    public BatchStockDTO(BatchStock batchStock) {
        this.batchNumber = batchStock.getBatchId();
        this.product = batchStock.getProduct().getId();
        this.currentTemperature = batchStock.getCurrentTemperature();
        this.minimumTemperature = batchStock.getMinimumTemperature();
        this.initialQuantity = batchStock.getInitialQuantity();
        this.currentQuantity = batchStock.getCurrentQuantity();
        this.manufacturingDate = batchStock.getManufacturingDate();
        this.manufacturingTime = batchStock.getManufacturingTime();
        this.dueDate = batchStock.getDueDate();

    }


}
