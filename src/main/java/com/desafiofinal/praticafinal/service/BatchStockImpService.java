package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.InBoundOrderRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatchStockImpService implements IBatchStockService {

    private final InBoundOrderRepo inBoundOrderRepo;

    private final IProductRepo productRepo;
    public BatchStockImpService(InBoundOrderRepo inBoundOrderRepo, IProductRepo productRepo) {
        this.inBoundOrderRepo = inBoundOrderRepo;
        this.productRepo = productRepo;
    }

    @Override
    public List<BatchStock> listBatchStockByCategory (String category) {

        List<InBoundOrder> listInBoundOrder = inBoundOrderRepo.findAll(); //TODO no final refatorar esse método
        List<BatchStock> batchListByCategory = new ArrayList<>();

        for (InBoundOrder inBoundOrder: listInBoundOrder){
            verifyDueDatePerCategory(category, batchListByCategory, inBoundOrder);
        }
        if(batchListByCategory.isEmpty()){
            throw new ElementNotFoundException("No products were found for this category");
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

}
