package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.modelEntity.*;
import com.desafiofinal.praticafinal.modelRequestResponseDto.InBoundOrderRequestDto;
import com.desafiofinal.praticafinal.modelRequestResponseDto.InBoundOrderResponseDto;
import com.desafiofinal.praticafinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public InBoundOrderResponseDto saveInBoundOrder (InBoundOrderRequestDto inBoundOrderRequestDto){

        InBoundOrder newInBoundOrder = InBoundOrderRequestDto.convertDtoToInBoundOrder(inBoundOrderRequestDto);

        Optional<InBoundOrder> foundInBoundOrder = inBoundOrderRepo.findById(newInBoundOrder.getOrderId());

        if(foundInBoundOrder.isPresent()){
            newInBoundOrder.setOrderId(foundInBoundOrder.get().getOrderId());

        }else {
            newInBoundOrder.setOrderId(0L);
        }

        for(BatchStock batchStock : newInBoundOrder.getBatchStockList()){

            Optional<BatchStock> foundBatchStock = batchStockRepo.findById(batchStock.getBatchId());

            if(foundBatchStock.isPresent()){
                batchStock.setBatchId(foundBatchStock.get().getBatchId());

                Optional<Product> foundProduct = productRepo.findById(batchStock.getProduct().getId());

                if(foundProduct.isPresent()){
                    batchStock.getProduct().setId(foundProduct.get().getId());
                }else{
                    batchStock.getProduct().setId(0L);
                }

                Optional<Seller> foundSeller = sellerRepo.findById(batchStock.getProduct().getSeller().getSellerId());

                if(foundSeller.isPresent()){
                    batchStock.getProduct().getSeller().setSellerId(foundSeller.get().getSellerId());
                }else{
                    batchStock.getProduct().getSeller().setSellerId(0L);
                }

            }else{
                batchStock.setBatchId(0L);

            }
            sellerRepo.save(batchStock.getProduct().getSeller());
            productRepo.save(batchStock.getProduct());
            batchStockRepo.save(batchStock);
        }

         Optional<Sector> foundSector = sectorRepo.findById(newInBoundOrder.getSector().getSectorId());

       if (foundSector.isPresent()){
            newInBoundOrder.getSector().setSectorId(foundSector.get().getSectorId());
        }else{
            newInBoundOrder.getSector().setSectorId(0L);
        }


        Optional<WareHouse> foundWareHouse = wareHouseRepo.findById(newInBoundOrder.getSector().getWareHouse().getWareHouseId());

        if(foundWareHouse.isPresent()){
            newInBoundOrder.getSector().getWareHouse().setWareHouseId(foundWareHouse.get().getWareHouseId());
        }else{
            newInBoundOrder.getSector().getWareHouse().setWareHouseId(0L);
        }


        Optional<Manager> foundManager = managerRepo.findById(newInBoundOrder.getSector().getWareHouse().getManager().getManagerId());
        if(foundManager.isPresent()){
            newInBoundOrder.getSector().getWareHouse().getManager().setManagerId(foundManager.get().getManagerId());
        }else{
            newInBoundOrder.getSector().getWareHouse().getManager().setManagerId(0L);
        }

        managerRepo.save(newInBoundOrder.getSector().getWareHouse().getManager());
        wareHouseRepo.save(newInBoundOrder.getSector().getWareHouse());
        sectorRepo.save(newInBoundOrder.getSector());



        InBoundOrder savedInBoundOrder = inBoundOrderRepo.save(newInBoundOrder);

        return  new InBoundOrderResponseDto(savedInBoundOrder);

    }

}
