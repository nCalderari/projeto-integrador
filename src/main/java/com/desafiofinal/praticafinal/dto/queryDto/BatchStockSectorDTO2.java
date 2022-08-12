package com.desafiofinal.praticafinal.dto.queryDto;

import com.desafiofinal.praticafinal.dto.BatchStockDTO;
import com.desafiofinal.praticafinal.model.BatchStock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchStockSectorDTO2 {

    private SectorQuery sector;

    private long productId;

    private List<StockQuery> stockList;

    public BatchStockSectorDTO2 (BatchStockSectorDTO batchStockSectorDTO ){
        this.sector.setSectorId(batchStockSectorDTO.getSectorId());

        this.productId = productId;
//        this.stockList =

//
//                new StockQuery(batchId,currentQuantity,sectorId, dueDate,category, productId)
//
//      ;
    }



}
