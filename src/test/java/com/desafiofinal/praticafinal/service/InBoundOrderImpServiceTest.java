package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.dto.ManagerDTO;
import com.desafiofinal.praticafinal.dto.SectorDTO;
import com.desafiofinal.praticafinal.dto.WareHouseDTO;
import com.desafiofinal.praticafinal.model.*;
import com.desafiofinal.praticafinal.repository.IBatchStockRepo;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.ISectorRepo;
import com.desafiofinal.praticafinal.repository.InBoundOrderRepo;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InBoundOrderImpServiceTest {

    @Mock
    private InBoundOrderRepo inBoundOrderRepo;

    @Mock
    private IBatchStockRepo batchStockRepo;

    @Mock
    private ISectorRepo sectorRepo;

    @Mock
    private IProductRepo productRepo;

    @SneakyThrows
    @Test
    void saveInBoundOrder() {

        var manager = new Manager(1L, "AMANDA", null);
        var wareHouse =  new WareHouse(1L, manager, Collections.emptyList());
        var sector = new Sector(1L, "Carne",
                12,
                Collections.emptyList(),
                wareHouse );
        var inBoundOrder = new InBoundOrder(1L, new Date(), Collections.emptyList(), sector );
        var seller = new Seller(1L, "TESTE", Collections.emptySet());
        var sectorDTO = new SectorDTO(sector);
        var product = new Product(1L, new Date(), 13, "frios", "frango", seller, 13, Collections.emptyList());
//        var inboundOrderRequestDTO = new InboundOrderRequestDTO(1L, inBoundOrder.getDateTime(), new SectorDTO(sector));

        lenient().when(inBoundOrderRepo.findById(null)).thenReturn(Optional.of(inBoundOrder));
        lenient().when(sectorRepo.findById(1L)).thenReturn(Optional.of(sector));
        lenient().when(productRepo.findById(anyLong())).thenReturn(Optional.of(product));
        lenient().when(inBoundOrderRepo.save(any(InBoundOrder.class))).thenReturn(inBoundOrder);

        var service = new InBoundOrderImpService(inBoundOrderRepo, batchStockRepo, sectorRepo, productRepo);
        var inboundOrderCreated =  service.saveInBoundOrder(new InboundOrderRequestDTO(20L, new Date(), sectorDTO,Collections.emptyList() ));

        Assertions.assertEquals(inBoundOrder.getOrderId(), inboundOrderCreated.getOrderId());
        Assertions.assertEquals(inBoundOrder.getDateTime(), inboundOrderCreated.getDateTime());
        Assertions.assertEquals(inBoundOrder.getBatchStockList(), inboundOrderCreated.getBatchStockList());
        Assertions.assertEquals(inBoundOrder.getSector(), inboundOrderCreated.getSector());

    }

    @SneakyThrows
    @Test
    void updateInBoundOrder()  {
//        var manager = new Manager(1L, "AMANDA", null);
//        var wareHouse =  new WareHouse(1L, manager, Collections.emptyList());
//        var sector = new Sector(1L, "Carne",
//                12,
//                Collections.emptyList(),
//                wareHouse );
//        var inBoundOrder = new InBoundOrder(1L, new Date(), Collections.emptyList(), sector );
//        var seller = new Seller(1L, "TESTE", Collections.emptySet());
//        var sectorDTO = new SectorDTO(sector);
//        var product = new Product(1L, new Date(), 13, "frios", "frango", seller, 13, Collections.emptyList());
////        var inboundOrderRequestDTO = new InboundOrderRequestDTO(1L, inBoundOrder.getDateTime(), new SectorDTO(sector));
//        var batchstockEntity = new BatchStock(1L, 12, 14, 20L, 7L, new Date(), new Date(), new Date(), inBoundOrder, product );
//        lenient().when(inBoundOrderRepo.findById(null)).thenReturn(Optional.of(inBoundOrder));
//        lenient().when(sectorRepo.findById(1L)).thenReturn(Optional.of(sector));
//        lenient().when(productRepo.findById(anyLong())).thenReturn(Optional.of(product));
//        lenient().when(batchStockRepo.findById(anyLong())).thenReturn(Optional.of(batchstockEntity));
//        lenient().when(batchStockRepo.save(any(InBoundOrder.class))).thenReturn(batchstockEntity);
//        lenient().when(batchStockRepo.saveAll(any(InBoundOrder.class))).thenReturn(batchstockEntity);
//
//        lenient().when(inBoundOrderRepo.save(any(InBoundOrder.class))).thenReturn(inBoundOrder);
//
//        var service = new InBoundOrderImpService(inBoundOrderRepo, batchStockRepo, sectorRepo, productRepo);
//        var inboundOrderCreated =  service.updateInBoundOrder(new InboundOrderRequestDTO(20L, new Date(), sectorDTO,Collections.emptyList() ));
//
//        Assertions.assertEquals(inBoundOrder.getOrderId(), inboundOrderCreated.getOrderId());
//        Assertions.assertEquals(inBoundOrder.getDateTime(), inboundOrderCreated.getDateTime());
//        Assertions.assertEquals(inBoundOrder.getBatchStockList(), inboundOrderCreated.getBatchStockList());
//        Assertions.assertEquals(inBoundOrder.getSector(), inboundOrderCreated.getSector());
    }
}