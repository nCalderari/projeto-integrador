package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.exception.ElementeAlreadyExistsException;
import com.desafiofinal.praticafinal.modelDto.BatchStockDTO;
import com.desafiofinal.praticafinal.modelEntity.*;
import com.desafiofinal.praticafinal.modelRequestResponseDto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.modelRequestResponseDto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public InBoundOrderResponseDTO saveInBoundOrder (InboundOrderRequestDTO inboundOrderRequestDTO) throws Exception {
        InBoundOrder inBoundOrder = convertToInBoundOrder(inboundOrderRequestDTO);

        Optional<InBoundOrder> foundInBoundOrder = inBoundOrderRepo.findById(inBoundOrder.getOrderId());

        //TODO USAR DEPOIS UM TERNARIO
        if(foundInBoundOrder.isPresent()){
            throw new ElementeAlreadyExistsException("In bound order already exists");
        }else {
            InBoundOrder savedInBoundOrder = inBoundOrderRepo.save(inBoundOrder);
            return new InBoundOrderResponseDTO(savedInBoundOrder);
        }
    }

    public InBoundOrderResponseDTO updateInBoundOrder (InboundOrderRequestDTO inBoundOrderRequestDto) throws Exception {

        InBoundOrder newUpdatedInBoundOrder = InboundOrderRequestDTO.convertDTOToInboundOrder(inBoundOrderRequestDto);

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

        return new InBoundOrderResponseDTO(updatedInBoundOrder);

    }

//    public InBoundOrderResponseDto inBoundOrderGetPrice (InBoundOrderRequestDto inBoundOrderRequestDto) {
//        InBoundOrder newInBoundOrder = InBoundOrderRequestDto.convertDtoToInBoundOrder(inBoundOrderRequestDto);
//
//        for (BatchStock batchStockProduct: newInBoundOrder.getBatchStockList()){
//            batchStockProduct.getProduct().getPrice();
//        }
//    }

    private InBoundOrder convertToInBoundOrder(InboundOrderRequestDTO inboundOrderRequestDTO) throws Exception {
        var inboundOrder = new InBoundOrder();
        var orderId = inboundOrderRequestDTO.getOrderId();
        var sectorID = inboundOrderRequestDTO.getSector().getSectorId();
        var productIDList = inboundOrderRequestDTO.
                getBatchStockList()
                .stream()
                .map(batchStockDTO -> batchStockDTO.getProduct().getId()).collect(Collectors.toList());
        Optional<Sector> foundSector = sectorRepo.findById(sectorID);

        if(foundSector.isPresent()){
            inboundOrder.setSector(foundSector.get());
        }else{
            throw new Exception("Não existe o setor");
        }

        var productList = productRepo.findAllById(productIDList);
        var batchList = inboundOrderRequestDTO.getBatchStockList().stream().map(dto -> {
            var product = productList
                    .stream().
                    filter( p -> p.getId() == dto.getProduct().getId())
                    .findFirst().get();

            return  new BatchStock(
                    dto.getBatchId(),
                    dto.getCurrentTemperature(),
                    dto.getMinimumTemperature(),
                    dto.getInitialQuantity(),
                    dto.getCurrentQuantity(),
                    dto.getManufacturingDate(),
                    dto.getManufacturingTime(),
                    dto.getDueDate(),
                    inboundOrder,
                    product);
        }).collect(Collectors.toList());

        inboundOrder.setBatchStockList(batchList);

        return inboundOrder;
    }
}


