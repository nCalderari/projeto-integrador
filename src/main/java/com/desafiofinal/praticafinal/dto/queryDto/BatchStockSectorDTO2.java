package com.desafiofinal.praticafinal.dto.queryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchStockSectorDTO2 {

    private SectorQuery sector;

    private long productId;

    private List<StockQuery> stockList;
}
