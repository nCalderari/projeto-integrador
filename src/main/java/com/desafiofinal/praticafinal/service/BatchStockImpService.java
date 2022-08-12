package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.queryDto.*;

import com.desafiofinal.praticafinal.exception.ElementAlreadyExistsException;
import com.desafiofinal.praticafinal.repository.IBatchStockRepo;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.InBoundOrderRepo;
import org.springframework.stereotype.Service;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.InBoundOrder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchStockImpService implements IBatchStockService {

    private final InBoundOrderRepo inBoundOrderRepo;

    private final IProductRepo productRepo;

    private final IBatchStockRepo batchStockRepo;
    public BatchStockImpService(InBoundOrderRepo inBoundOrderRepo, IProductRepo productRepo, IBatchStockRepo batchStockRepo) {
        this.inBoundOrderRepo = inBoundOrderRepo;
        this.productRepo = productRepo;
        this.batchStockRepo = batchStockRepo;
    }

    @Override
    public List<BatchStock> listBatchStockByCategory (String category) {

        List<InBoundOrder> listInBoundOrder = inBoundOrderRepo.findAll(); //TODO no final refatorar esse método
        List<BatchStock> batchListByCategory = new ArrayList<>();

        for (InBoundOrder inBoundOrder: listInBoundOrder){
            verifyDueDatePerCategory(category, batchListByCategory, inBoundOrder);
        }
        if(batchListByCategory.isEmpty()){
            throw new ElementAlreadyExistsException("No products were found for this category");
        }else {
            return batchListByCategory;
        }
    }

    private void verifyDueDatePerCategory(String category, List<BatchStock> batchListByCategory, InBoundOrder inBoundOrder) {
        String foundCategory = inBoundOrder.getSector().getCategory();

        if(foundCategory.equalsIgnoreCase(category)){
            for (BatchStock batchStock: inBoundOrder.getBatchStockList()){
                LocalDate minusDays2 = batchStock.getDueDate().minusDays(21);
                if(LocalDate.now().isBefore(minusDays2)){
                    batchListByCategory.add(batchStock);
                }
            }
        }
    }


    public List<ResponseSectorQuery> listBatchSector(long id) {

        List<DataBaseQuery> listBatchSector = batchStockRepo.getListBatchSector(id);

        if (listBatchSector.isEmpty()) {
            throw new RuntimeException("Não há lote de produtos com esse id");
        }


        return buildResponseQueryList(listBatchSector);
    }

    private List<ResponseSectorQuery> buildResponseQueryList(List<DataBaseQuery> listBatchSector) {
        ResponseSectorQuery responseSectorQuery;
        List<ResponseSectorQuery> responseSectorQueryList = new ArrayList<>();
        List<SectorQuery> sectorQueryList = new ArrayList<>();

        List<StockQuery> stockQueryList = new ArrayList<>();

        for (DataBaseQuery batchStockSectorDTO : listBatchSector) {
            StockQuery stockQuery = StockQuery.builder()
                    .batchId(batchStockSectorDTO.getBatch_id())
                    .currentQuantity(batchStockSectorDTO.getCurrent_quantity())
                    .dueDate(batchStockSectorDTO.getDue_date())
                    .sectorId(batchStockSectorDTO.getSector_id())
                    .productId(batchStockSectorDTO.getId_product())
                    .build();
            stockQueryList.add(stockQuery);

            SectorQuery sectorQuery = new SectorQuery();
            sectorQuery.setCategory(batchStockSectorDTO.getCategory());
            sectorQuery.setSectorId(batchStockSectorDTO.getSector_id());

            if (!sectorQueryList.contains(sectorQuery)) {
                sectorQueryList.add(sectorQuery);
            }
        }

        for (SectorQuery sector : sectorQueryList) {
            List<StockQuery> responseStock = stockQueryList.stream().filter(stock -> stock.getSectorId() == sector.getSectorId()).collect(Collectors.toList());

            responseSectorQuery = ResponseSectorQuery.builder()
                    .sector(sector)
                    .productId(responseStock.get(0).getProductId())
                    .stockList(responseStock)
                    .build();

            responseSectorQueryList.add(responseSectorQuery);

        }
        return responseSectorQueryList;
    }


    public List<ResponseSectorQuery> listBatchSectorOrdered(long id, String string) throws Exception {
        List<ResponseSectorQuery> responseSectorQueryList;
        List<DataBaseQuery> dataBaseQuery;
//trocar por switch case
        if (string.equalsIgnoreCase("L")) {
            dataBaseQuery = batchStockRepo.getListOrderedById(id);
            responseSectorQueryList = buildResponseQueryList(dataBaseQuery);
        } else if (string.equalsIgnoreCase("Q")) {
            dataBaseQuery = batchStockRepo.getListOrderedByQuantity(id);
            responseSectorQueryList = buildResponseQueryList(dataBaseQuery);
        } else if (string.equalsIgnoreCase("V")) {
            dataBaseQuery = batchStockRepo.getListOrderedByDueDate(id);
            responseSectorQueryList = buildResponseQueryList(dataBaseQuery);
        } else {
            throw new Exception("Essa opção de ordenação não existe");
        }
        return responseSectorQueryList;
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

//    public List<DataBaseQuery> getListDueDate (long days, long idSector){
//
//        List<DataBaseQuery> litDueDate = batchStockRepo.getListDueDate();
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



