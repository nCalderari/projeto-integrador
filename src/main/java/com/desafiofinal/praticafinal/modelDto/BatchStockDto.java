package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import com.desafiofinal.praticafinal.modelEntity.InBoundOrder;
import com.desafiofinal.praticafinal.modelEntity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchStockDto {


    private long batchId;

    private float currentTemperature;

    private float minimumTemperature;

    private long initialQuantity;

    private long currentQuantity;

    private LocalDate manufacturingDate;

    private LocalDate manufacturingTime;

    private LocalDate dueDate;


    private InBoundOrder inBoundOrderId;


    private ProductDto productDto;

    public BatchStockDto(BatchStock batchStock) {
        this.batchId = batchStock.getBatchId();
        this.currentTemperature = batchStock.getCurrentTemperature();
        this.minimumTemperature = batchStock.getMinimumTemperature();
        this.initialQuantity = batchStock.getInitialQuantity();
        this.currentQuantity = batchStock.getCurrentQuantity();
        this.manufacturingDate = batchStock.getManufacturingDate();
        this.manufacturingTime = batchStock.getManufacturingTime();
        this.dueDate = batchStock.getDueDate();
        this.inBoundOrderId = batchStock.getInBoundOrder();
      //  this.product = new Product(batchStock.getProduct());
    }

//    public BatchStock convertBatchStockDtoToBatchStock (BatchStockDto batchStockDto){
//        return BatchStock.builder()
//                .batchId(batchStockDto.getBatchId())
//                .currentTemperature(batchStockDto.getCurrentTemperature())
//                .minimumTemperature(batchStockDto.getMinimumTemperature())
//                .initialQuantity(batchStockDto.getInitialQuantity())
//                .currentQuantity(batchStockDto.getCurrentQuantity())
//                .manufacturingDate(batchStockDto.getManufacturingDate())
//                .manufacturingTime(batchStockDto.getManufacturingTime())
//                .dueDate(batchStockDto.getDueDate())
//                .inBoundOrderId()
//                .product(batchStockDto.getProduct())
//                .build();
//    }
}
