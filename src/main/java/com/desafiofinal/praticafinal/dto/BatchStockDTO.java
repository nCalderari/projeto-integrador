package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.dto.requestResponseDto.ProductDTO;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchStockDTO {


    private long batchNumber;

    @Nullable
    private long product;

    private float currentTemperature;

    private float minimumTemperature;

    private long initialQuantity;

    private long currentQuantity;

    private LocalDate manufacturingDate;

    private LocalDate manufacturingTime;

    private LocalDate dueDate;

    private InBoundOrder inBoundOrderId;

    private ProductDTO productDto;

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

    public static BatchStock convertBatchStockDtoToBatchStock (BatchStockDTO batchStockDto){
        return BatchStock.builder()
                .batchId(batchStockDto.getBatchNumber())
                .currentTemperature(batchStockDto.getCurrentTemperature())
                .minimumTemperature(batchStockDto.getMinimumTemperature())
                .initialQuantity(batchStockDto.getInitialQuantity())
                .currentQuantity(batchStockDto.getCurrentQuantity())
                .manufacturingDate(batchStockDto.getManufacturingDate())
                .manufacturingTime(batchStockDto.getManufacturingTime())
                .dueDate(batchStockDto.getDueDate())
                .build();
    }


    public static List<BatchStock> convertToListEntity (List<BatchStockDTO> batchStockDtoList){
        List<BatchStock> batchStockList = new ArrayList<>();
        for(BatchStockDTO batchStockDto: batchStockDtoList){
            batchStockList.add(convertBatchStockDtoToBatchStock(batchStockDto));
        }
        return batchStockList;
    }

    public static List<BatchStockDTO> convertToListDto (List<BatchStock> batchStockList){
        List<BatchStockDTO> batchStockListDto = new ArrayList<>();
        for(BatchStock batchStock: batchStockList){
            batchStockListDto.add(new BatchStockDTO(batchStock));
        }
        return batchStockListDto;
    }
}
