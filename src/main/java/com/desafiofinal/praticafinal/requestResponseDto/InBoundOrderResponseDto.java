package com.desafiofinal.praticafinal.requestResponseDto;

import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InBoundOrderResponseDto {

    private List<BatchStock> batchStockList;

    public InBoundOrderResponseDto (InBoundOrder inBoundOrder) {
        this.batchStockList = inBoundOrder.getBatchStockList();
    }

}
