package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import com.desafiofinal.praticafinal.modelEntity.InBoundOrder;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BatchStockDTO {


    private long batchId;

    private float currentTemperature;

    private float minimumTemperature;

    private long initialQuantity;

    private long currentQuantity;

    private Date manufacturingDate;

    private Date manufacturingTime;

    private Date dueDate;

    @Nullable
    private InBoundOrder inBoundOrderId;

    @Nullable
    private ProductDTO product;

    public BatchStockDTO(BatchStock batchStock) {
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

   /* public BatchStock convertBatchStockDtoToBatchStock (BatchStockDto batchStockDto){
        return BatchStock.builder()
                .batchId(batchStockDto.getBatchId())
                .currentTemperature(batchStockDto.getCurrentTemperature())
                .minimumTemperature(batchStockDto.getMinimumTemperature())
                .initialQuantity(batchStockDto.getInitialQuantity())
                .currentQuantity(batchStockDto.getCurrentQuantity())
                .manufacturingDate(batchStockDto.getManufacturingDate())
                .manufacturingTime(batchStockDto.getManufacturingTime())
                .dueDate(batchStockDto.getDueDate())
                .inBoundOrderId(batchStockDto.getInBoundOrderId())
              //  .product(batchStockDto.getProduct())
                .build();
    }*/
}
