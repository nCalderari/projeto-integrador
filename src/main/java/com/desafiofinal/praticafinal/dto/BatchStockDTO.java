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
    private ProductDTO product;

    private float currentTemperature;

    private float minimumTemperature;

    private long initialQuantity;

    private long currentQuantity;

    private LocalDate manufacturingDate;

    private LocalDate manufacturingTime;

    private LocalDate dueDate;

    private Long inBoundOrderId;



    public BatchStockDTO(BatchStock batchStock) {
        this.batchNumber = batchStock.getBatchId();
        this.product = new ProductDTO(batchStock.getProduct());
        this.currentTemperature = batchStock.getCurrentTemperature();
        this.minimumTemperature = batchStock.getMinimumTemperature();
        this.initialQuantity = batchStock.getInitialQuantity();
        this.currentQuantity = batchStock.getCurrentQuantity();
        this.manufacturingDate = batchStock.getManufacturingDate();
        this.manufacturingTime = batchStock.getManufacturingTime();
        this.dueDate = batchStock.getDueDate();
        this.inBoundOrderId = batchStock.getInBoundOrder().getOrderId();
    }

    public static BatchStock convertBatchStockDtoToBatchStock (BatchStockDTO batchStockDto){
        return BatchStock.builder()
                .batchId(batchStockDto.getBatchNumber())
                .product(ProductDTO.convertDtoToProductIdOnly(batchStockDto.getProduct()))
                .currentTemperature(batchStockDto.getCurrentTemperature())
                .minimumTemperature(batchStockDto.getMinimumTemperature())
                .initialQuantity(batchStockDto.getInitialQuantity())
                .currentQuantity(batchStockDto.getCurrentQuantity())
                .manufacturingDate(batchStockDto.getManufacturingDate())
                .manufacturingTime(batchStockDto.getManufacturingTime())
                .dueDate(batchStockDto.getDueDate())
                .build();
    }
    public static BatchStock convertBatchStockDtoToBatchStockIdOnly (BatchStockDTO batchStockDto){
        return BatchStock.builder()
                .batchId(batchStockDto.getBatchNumber())
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
