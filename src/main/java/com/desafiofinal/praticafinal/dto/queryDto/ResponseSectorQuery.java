package com.desafiofinal.praticafinal.dto.queryDto;

import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.dto.requestResponseDto.BatchStockResponseDto;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseSectorQuery {

    private SectorQuery sector;

    private long productId;

    private List<StockQuery> stockList;


}
