package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.CartDto;
import com.desafiofinal.praticafinal.dto.queryDto.*;
import com.desafiofinal.praticafinal.dto.requestResponseDto.BatchStockResponseDto;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.model.Sector;
import com.desafiofinal.praticafinal.repository.IBatchStockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchStockImpService {

    @Autowired
    private IBatchStockRepo batchStockRepo;

//    public List<ResponseSectorQuery> listBatchSector(long id) {
//
//        List<BatchStockSectorDTO> listBatchSector = batchStockRepo.getListBatchSector(id);
//        if (listBatchSector.isEmpty()) {
//            throw new RuntimeException("Não há lote de produtos com esse id");
//        }
//        ResponseSectorQuery responseSectorQuery;
//        List<ResponseSectorQuery> responseSectorQueryList = new ArrayList<>();
//        List<SectorQuery> sectorQueryList = new ArrayList<>();
//
//        List<StockQuery> stockQueryList = new ArrayList<>();
//
//        for (BatchStockSectorDTO batchStockSectorDTO : listBatchSector) {
//            StockQuery stockQuery = StockQuery.builder()
//                    .batchId(batchStockSectorDTO.getBatchId())
//                    .currentQuantity(batchStockSectorDTO.getCurrentQuantity())
//                    .dueDate(batchStockSectorDTO.getDueDate())
//                    .sectorId(batchStockSectorDTO.getSectorId())
//                    .productId(batchStockSectorDTO.getProductId())
//                    .build();
//            stockQueryList.add(stockQuery);
//
//            SectorQuery sectorQuery = new SectorQuery();
//            sectorQuery.setCategory(batchStockSectorDTO.getCategory());
//            sectorQuery.setSectorId(batchStockSectorDTO.getSectorId());
//
//            if (!sectorQueryList.contains(sectorQuery)) {
//                sectorQueryList.add(sectorQuery);
//            }
//        }
//
//        for (SectorQuery sector : sectorQueryList) {
//            List<StockQuery> responseStock = stockQueryList.stream().filter(stock -> stock.getSectorId() == sector.getSectorId()).collect(Collectors.toList());
//
//            responseSectorQuery = ResponseSectorQuery.builder()
//                    .sector(sector)
//                    .productId(responseStock.get(0).getProductId())
//                    .stockList(responseStock)
//                    .build();
//
//            responseSectorQueryList.add(responseSectorQuery);
//
//        }
//        return responseSectorQueryList;
//    }


    public List<BatchStockSectorDTO> listBatchSectorOrdered(long id, String string) throws Exception {
        List<BatchStockSectorDTO> batchStockSectorDTO;
//trocar por switch case
        if (string.equalsIgnoreCase("L")) {
            batchStockSectorDTO = batchStockRepo.getListOrderedById(id);
        } else if (string.equalsIgnoreCase("Q")) {
            batchStockSectorDTO = batchStockRepo.getListOrderedByQuantity(id);
        } else if (string.equalsIgnoreCase("V")) {
            batchStockSectorDTO = batchStockRepo.getListOrderedByDueDate(id);
        } else {
            throw new Exception("Essa opção de ordenação não existe");
        }
        return batchStockSectorDTO;
    }

    //Requisito 4
//
//    public List<BatchStockSectorQuantityDTO> getTotalQuantity(long id) {
//
//        List<BatchStockSectorQuantityDTO> batchStockSectorList = batchStockRepo.getListQuantity(id);
//        return batchStockSectorList;
//
//    }
//}

//Requisito 5

//    public List<BatchStockSectorDTO> getListDueDate (long days, long idSector){
//
//        List<BatchStockSectorDTO> litDueDate = batchStockRepo.getListDueDate();
//
//        LocalDate minusDays2 = batchStock.getDueDate().minusDays(days);
//        Period.between(LocalDate.now(), minusDays2).getDays();
//
//        minusDays2 = batchStock.getDueDate().minusDays(days);
////
////                    if(LocalDate.now().isBefore(minusDays2)){
////
////        batchListByCategory.add(batchResponseDto);
////
//
//    }

}



