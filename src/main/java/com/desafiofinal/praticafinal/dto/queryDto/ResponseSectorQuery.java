package com.desafiofinal.praticafinal.dto.queryDto;

import com.desafiofinal.praticafinal.dto.requestResponseDto.InBoundOrderRequestDTO;
import com.desafiofinal.praticafinal.dto.requestResponseDto.BatchStockResponseDTO;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseSectorQuery {

    private SectorQuery sector;

    private long productId;

    private List<StockQuery> stockList;

    public ResponseSectorQuery (List<BatchStockSectorDTO> batchStockSectorDTOList ){

            //List<SectorQuery> sectorQueryList =new ArrayList<>();
//           List<StockQuery> stockQueryList = new ArrayList<>();
//        for(BatchStockSectorDTO batchStockSectorDTO: batchStockSectorDTOList )  {
//               StockQuery stockQuery = StockQuery.builder()
//                                .batchId(batchStockSectorDTO.getBatchId())
//                                .currentQuantity(batchStockSectorDTO.getCurrentQuantity())
//                                .dueDate(batchStockSectorDTO.getDueDate())
//                                .sectorId(batchStockSectorDTO.getSectorId())
//                                .build();
//                        stockQueryList.add(stockQuery);
//             stockQueryList.add(stockQuery);
//              SectorQuery sectorQuery = new SectorQuery();
//                          sectorQuery.setCategory(batchStockSectorDTO.getCategory());
//                          sectorQuery.setSectorId(batchStockSectorDTO.getSectorId());

           // this.stockList= ().stream().filter(stock -> stock.getSectorId() == this.sector.setSectorId(batchStockSectorDTO.getSectorId())).collect(Collectors.toList()); ;
        }
//
//         this.stockList=stockQueryList.stream().filter(stockQuery -> stockQuery.getSectorId()==)
//         this.sector.setSectorId(batchStockSectorDTO.getSectorId());
//        this.productId = productId;


                      //    List<StockQuery> responseStock = stockQueryList.stream().filter(stock -> stock.getSectorId() == sector.getSectorId()).collect(Collectors.toList());

//
//                new StockQuery(batchId,currentQuantity,sectorId, dueDate,category, productId)
//
//      ;
    }


