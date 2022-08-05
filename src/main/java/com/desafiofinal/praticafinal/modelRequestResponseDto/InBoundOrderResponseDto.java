package com.desafiofinal.praticafinal.modelRequestResponseDto;

import com.desafiofinal.praticafinal.modelDto.BatchStockDto;
import com.desafiofinal.praticafinal.modelEntity.InBoundOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InBoundOrderResponseDto {

    private List<BatchStockDto> batchStockList;

    public InBoundOrderResponseDto (InBoundOrder inBoundOrder) {
        this.batchStockList = inBoundOrder.getBatchStockList().stream().map(entity -> new BatchStockDto(entity)).collect(Collectors.toList());
    }

}
