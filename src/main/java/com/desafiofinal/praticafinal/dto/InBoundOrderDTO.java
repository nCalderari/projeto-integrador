package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class InBoundOrderDTO {

    private List<BatchStockDTO> batchStockList;
    public InBoundOrderDTO(InBoundOrder inBoundOrder) {
        this.batchStockList = BatchStockDTO.convertToListDto(inBoundOrder.getBatchStockList());
    }

    public static InBoundOrder convertToInBoundOrder(InBoundOrderDTO inBoundOrderDTO){
        List<BatchStock> newBatchStockList = BatchStockDTO.convertToListEntity(inBoundOrderDTO.getBatchStockList());

        return InBoundOrder.builder()
                .batchStockList(newBatchStockList)
                .build();
    }

    public static List<InBoundOrderDTO> convertListToDTO(List<InBoundOrder> inBoundOrderList){
        return inBoundOrderList.stream()
                .map(InBoundOrderDTO::new)
                .collect(Collectors.toList());
    }

    public static List<InBoundOrder> convertListToEntity(List<InBoundOrderDTO> inBoundOrderDTOList) {
        return inBoundOrderDTOList.stream()
                .map(InBoundOrderDTO::convertToInBoundOrder)
                .collect(Collectors.toList());
    }


}
