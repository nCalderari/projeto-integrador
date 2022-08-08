package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.modelEntity.*;
import com.desafiofinal.praticafinal.modelRequestResponseDto.InBoundOrderRequestDto;
import com.desafiofinal.praticafinal.modelRequestResponseDto.InBoundOrderResponseDto;
import com.desafiofinal.praticafinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InBoundOrderImpService {

    @Autowired
    private InBoundOrderRepo inBoundOrderRepo;

    @Autowired
    private BatchStockRepo batchStockRepo;

    @Autowired
    private SectorRepo sectorRepo;

    @Autowired
    private WareHouseRepo wareHouseRepo;

    @Autowired
    private ManagerRepo managerRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SellerRepo sellerRepo;

    @Transactional
    public InBoundOrderResponseDto saveInBoundOrder (InBoundOrderRequestDto inBoundOrderRequestDto) throws Exception {

        InBoundOrder newInBoundOrder = InBoundOrderRequestDto.convertDtoToInBoundOrder(inBoundOrderRequestDto);

        //TODO FAZER UM FOREACH
        for(BatchStock batchStock : newInBoundOrder.getBatchStockList()){

            Optional<Product> foundProduct = productRepo.findById(batchStock.getProduct().getId());

            if(foundProduct.isPresent()){
                batchStock.setProduct(foundProduct.get());
            }else {
                throw new Exception("Não existe o produto");
            }

            batchStock.setInBoundOrder(newInBoundOrder);

        }

        Optional<Sector> foundSector = sectorRepo.findById(newInBoundOrder.getSector().getSectorId());

        if(foundSector.isPresent()){
            newInBoundOrder.setSector(foundSector.get());
        }else{
            throw new Exception("Não existe o setor");
        }

        InBoundOrder savedInBoundOrder = inBoundOrderRepo.save(newInBoundOrder);

        return new InBoundOrderResponseDto(savedInBoundOrder);

    }

    public InBoundOrderResponseDto updateInBoundOrder (InBoundOrderRequestDto inBoundOrderRequestDto) throws Exception {

        InBoundOrder newUpdatedInBoundOrder = InBoundOrderRequestDto.convertDtoToInBoundOrder(inBoundOrderRequestDto);

        Optional<InBoundOrder> foundInBoundOrder = inBoundOrderRepo.findById(newUpdatedInBoundOrder.getOrderId());
        //TODO USAR DEPOIS UM TERNARIO
        if(foundInBoundOrder.isPresent()){

           inBoundOrderRepo.save(newUpdatedInBoundOrder);

        }else {
            throw new Exception("nao encontrado");
        }

        List<BatchStock> tempBatchList = new ArrayList();

        for(BatchStock batchStock : newUpdatedInBoundOrder.getBatchStockList()){

            tempBatchList.add(batchStock);
        }

        for(BatchStock responseStock : tempBatchList)
        {
            Optional<BatchStock> foundBatch = batchStockRepo.findById(responseStock.getBatchId());
            if(foundBatch.isPresent())
            {
                if ((foundBatch.get().getInBoundOrder().getOrderId()== newUpdatedInBoundOrder.getOrderId())){
                    responseStock.setInBoundOrder(newUpdatedInBoundOrder);
                    batchStockRepo.save(responseStock);
                }else {
                    throw new Exception("O batchStock não pertence ao inBoundOrder");
                }

            }
            else
            {
                throw new Exception("Este Batch não existe");
            }
        }

        InBoundOrder updatedInBoundOrder = inBoundOrderRepo.save(newUpdatedInBoundOrder);

        return new InBoundOrderResponseDto(updatedInBoundOrder);

    }

//    public InBoundOrderResponseDto inBoundOrderGetPrice (InBoundOrderRequestDto inBoundOrderRequestDto) {
//        InBoundOrder newInBoundOrder = InBoundOrderRequestDto.convertDtoToInBoundOrder(inBoundOrderRequestDto);
//
//        for (BatchStock batchStockProduct: newInBoundOrder.getBatchStockList()){
//            batchStockProduct.getProduct().getPrice();
//        }
//    }

}
