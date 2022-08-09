package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import lombok.Data;

import java.util.List;

@Data
public class InBoundOrderDTO {
    public InBoundOrderDTO(List<BatchStockDTO> batchStockList) {
        this.batchStockList = batchStockList;
    }

    private List<BatchStockDTO> batchStockList;

}
