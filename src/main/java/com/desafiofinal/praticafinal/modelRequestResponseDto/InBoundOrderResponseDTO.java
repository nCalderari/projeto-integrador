package com.desafiofinal.praticafinal.modelRequestResponseDto;

import com.desafiofinal.praticafinal.modelDto.BatchStockDTO;
import com.desafiofinal.praticafinal.modelDto.InBoundOrderDTO;
import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import com.desafiofinal.praticafinal.modelEntity.InBoundOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InBoundOrderResponseDTO {

    private List<BatchStockDTO> batchStockList;

    public InBoundOrderResponseDTO(InBoundOrder inBoundOrder) {
         this.batchStockList =  inBoundOrder.getBatchStockList().stream().map( bs -> new BatchStockDTO(bs)).collect(Collectors.toList());
    }

}
