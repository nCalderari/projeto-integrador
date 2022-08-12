package com.desafiofinal.praticafinal.dto.requestResponseDto;

import com.desafiofinal.praticafinal.dto.BatchStockDTO;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InBoundOrderResponseDTO {

    private List<BatchStockDTO> batchStockList;

    public InBoundOrderResponseDTO(InBoundOrder inBoundOrder) {
         this.batchStockList = BatchStockDTO.convertToListDto(inBoundOrder.getBatchStockList());
    }

}
