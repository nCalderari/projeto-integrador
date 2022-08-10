package com.desafiofinal.praticafinal.dto.requestResponseDto;

import com.desafiofinal.praticafinal.model.BatchStock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchStockResponseDto {

    private long batchId;

    private long currentQuantity;

    private LocalDate dueDate;

    private ProductDTO productDto;

    public BatchStockResponseDto(BatchStock batchStock) {
        this.batchId = batchStock.getBatchId();
        this.currentQuantity = batchStock.getCurrentQuantity();
        this.dueDate = batchStock.getDueDate();
        this.productDto = new ProductDTO(batchStock.getProduct());
    }

    public static BatchStock convertBatchStockDtoToBatchStock (BatchStockResponseDto batchStockDto){
        return BatchStock.builder()
                .batchId(batchStockDto.getBatchId())
                .currentQuantity(batchStockDto.getCurrentQuantity())
                .dueDate(batchStockDto.getDueDate())
                .product(ProductDTO.convertDtoToProduct(batchStockDto.getProductDto()))
                .build();
    }

    public static List<BatchStock> convertToListEntity (List<BatchStockResponseDto> batchStockDtoList){
        List<BatchStock> batchStockList = new ArrayList<>();
        for(BatchStockResponseDto batchStockDto: batchStockDtoList){
            batchStockList.add(convertBatchStockDtoToBatchStock(batchStockDto));
        }
        return batchStockList;
    }

    public static List<BatchStockResponseDto> convertToListDto (List<BatchStock> batchStockList){
        List<BatchStockResponseDto> batchStockListDto = new ArrayList<>();
        for(BatchStock batchStock: batchStockList){
            batchStockListDto.add(new BatchStockResponseDto(batchStock));
        }
        return batchStockListDto;
    }
}
