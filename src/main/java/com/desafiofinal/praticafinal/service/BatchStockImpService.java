package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.BatchStockSectorDTO;
import com.desafiofinal.praticafinal.repository.IBatchStockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchStockImpService {

    @Autowired
    private IBatchStockRepo batchStockRepo;

    public List<BatchStockSectorDTO> listBatchSector(long id) throws Exception {
        List<BatchStockSectorDTO> listBatchSector = batchStockRepo.getListBatchSector(id);
        if ( listBatchSector.isEmpty()){
            throw new Exception("Não há lote de produtos com esse id");
        }

        return listBatchSector;
    }

    public List<BatchStockSectorDTO> ListBatchSectorOrdered (long id, String string) throws Exception {
        List<BatchStockSectorDTO> batchStockSectorDTO;

        if(string.equalsIgnoreCase("L")){
           batchStockSectorDTO = batchStockRepo.getListOrderedById(id);
        }
        else if(string.equalsIgnoreCase("Q")){
            batchStockSectorDTO = batchStockRepo.getListOrderedByQuantity(id);
        }
        else if(string.equalsIgnoreCase("V")){
            batchStockSectorDTO = batchStockRepo.getListOrderedByDueDate(id);
        }
        else {
            throw new Exception("Essa opção de ordenação não existe");
        }
        return  batchStockSectorDTO;
    }

}
