package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.BatchStockDTO;
import com.desafiofinal.praticafinal.dto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.exception.ElementeAlreadyExistsException;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Sector;
import com.desafiofinal.praticafinal.repository.IBatchStockRepo;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.ISectorRepo;
import com.desafiofinal.praticafinal.repository.InBoundOrderRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InBoundOrderImpService implements IinboundOrderService {

    private InBoundOrderRepo inBoundOrderRepo;

    private IBatchStockRepo batchStockRepo;

    private ISectorRepo sectorRepo;

    private IProductRepo productRepo;

    public InBoundOrderImpService(InBoundOrderRepo inBoundOrderRepo, IBatchStockRepo batchStockRepo, ISectorRepo sectorRepo, IProductRepo productRepo) {
        this.inBoundOrderRepo = inBoundOrderRepo;
        this.batchStockRepo = batchStockRepo;
        this.sectorRepo = sectorRepo;
        this.productRepo = productRepo;
    }

    @Transactional
    public InBoundOrderResponseDTO saveInBoundOrder (InboundOrderRequestDTO inboundOrderRequestDTO) throws Exception {
        InBoundOrder inBoundOrder = foundInBoundOrder(inboundOrderRequestDTO);

        Optional<InBoundOrder> foundInBoundOrder = inBoundOrderRepo.findById(inBoundOrder.getOrderId());

        if(foundInBoundOrder.isPresent())  throw new ElementeAlreadyExistsException("In bound order already exists");
        List<BatchStock> batchList = convertBatchStockList(inboundOrderRequestDTO, inBoundOrder);
        inBoundOrder.setBatchStockList(batchList);
        InBoundOrder savedInBoundOrder = inBoundOrderRepo.save(inBoundOrder);
        return new InBoundOrderResponseDTO(savedInBoundOrder);

    }

    public InBoundOrderResponseDTO updateInBoundOrder (InboundOrderRequestDTO inBoundOrderRequestDto) throws Exception {

        InBoundOrder inBoundOrder = foundInBoundOrder(inBoundOrderRequestDto);

        Optional<InBoundOrder> foundInBoundOrder = inBoundOrderRepo.findById(inBoundOrderRequestDto.getOrderId());
        if(foundInBoundOrder.isPresent()){
            List<BatchStock> batchList = convertBatchStockList(inBoundOrderRequestDto, inBoundOrder);
            verifyBatchStock(batchList, inBoundOrder);
            inBoundOrder.setBatchStockList(batchList);
            batchStockRepo.saveAll(inBoundOrder.getBatchStockList());
            InBoundOrder updatedInBoundOrder = inBoundOrderRepo.save(inBoundOrder);
            return new InBoundOrderResponseDTO(updatedInBoundOrder);

        }
            throw new ElementNotFoundException("In bound order does not exists");

    }

    private InBoundOrder foundInBoundOrder(InboundOrderRequestDTO inboundOrderRequestDTO) throws Exception {
        InBoundOrder inboundOrder = new InBoundOrder();
        Optional<InBoundOrder> foundInBundOrder = inBoundOrderRepo.findById(inboundOrderRequestDTO.getOrderId());
        if(foundInBundOrder.isPresent()){
            inboundOrder.setOrderId(foundInBundOrder.get().getOrderId());

        } else{
            inboundOrder.setOrderId(0L);
        }
        var sectorID = inboundOrderRequestDTO.getSector().getSectorId();
        verifySector(inboundOrder, sectorID);

        return inboundOrder;
    }

    private List<BatchStock> convertBatchStockList(InboundOrderRequestDTO inboundOrderRequestDTO, InBoundOrder inboundOrder) {
        return inboundOrderRequestDTO.getBatchStockList().stream().map(dto -> {
            Product product = verifyProduct(dto);

            return  new BatchStock(
                    dto.getBatchNumber(),
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
    }

    private void verifySector(InBoundOrder inboundOrder, long sectorID) {
        Optional<Sector> foundSector = Optional.ofNullable(sectorRepo.findById(sectorID)
                .orElseThrow(() -> new RuntimeException("Sector does not exists")));
        inboundOrder.setSector(foundSector.get());
    }

    private Product verifyProduct(BatchStockDTO batchStockDTO) {
        Optional<Product> foundProduct = Optional.ofNullable(productRepo.findById(batchStockDTO.getProduct())
                .orElseThrow(() -> new RuntimeException("Product does ot exists")));
                    return foundProduct.get();

    }

    private void verifyBatchStock(List<BatchStock> batchStockList, InBoundOrder inBoundOrder) throws Exception {
        for(BatchStock responseStock : batchStockList) {
            Optional<BatchStock> foundBatch = batchStockRepo.findById(responseStock.getBatchId());
            if(foundBatch.isPresent()) {
                if ((foundBatch.get().getInBoundOrder().getOrderId() == inBoundOrder.getOrderId())) {
                    responseStock.setInBoundOrder(inBoundOrder);
                    batchStockRepo.save(responseStock);
                } else {
                    throw new ElementNotFoundException("Batch stock does not belongs to this inbound order");
                }
            } else {
                throw new ElementNotFoundException("Batch stock does not exists");
            }
        }
    }
}


