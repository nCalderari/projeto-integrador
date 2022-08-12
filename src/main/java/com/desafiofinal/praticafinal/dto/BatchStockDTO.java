package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.BatchStock;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BatchStockDTO {


    private Long batchNumber;

    @NotNull(message = "Please enter a valid product")
    private Long product;

    @NotNull(message = "Current temperature cannot be null")
    private Float currentTemperature;

    @NotNull(message = "Initial temperature cannot be null")
    private Float minimumTemperature;
    @NotNull(message = "Initial quantity cannot be null")
    @DecimalMin(value = "1", message = "Initial quantity cannot be less than 1")
    private Long initialQuantity;

    private Long currentQuantity;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @NotNull(message = "Manufacturing Date cannot be null. Format: yyyy/MM/dd")
    private LocalDate manufacturingDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @NotNull(message = "Manufacturing Date cannot be null. Format: yyyy/MM/dd")
    private LocalDate manufacturingTime;

    @Future(message = "Due date must be in the future")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @NotNull(message = "Due date cannot be null")
    private LocalDate dueDate;


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
