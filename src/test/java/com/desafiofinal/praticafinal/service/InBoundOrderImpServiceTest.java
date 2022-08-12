package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.BatchStockDTO;
import com.desafiofinal.praticafinal.dto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.dto.SectorDTO;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.model.Manager;
import com.desafiofinal.praticafinal.model.Sector;
import com.desafiofinal.praticafinal.model.WareHouse;
import com.desafiofinal.praticafinal.repository.IBatchStockRepo;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.ISectorRepo;
import com.desafiofinal.praticafinal.repository.InBoundOrderRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class InBoundOrderImpServiceTest {

    @Mock
    private InBoundOrderRepo inBoundOrderRepo;

    @Mock
    private IBatchStockRepo batchStockRepo;

    @Mock
    private ISectorRepo sectorRepo;

    @Mock
    private IProductRepo productRepo;
    private Object List;


    @Test
    void saveInBoundOrder() throws Exception {
        var manager = new Manager(1L, "AMANDA", null);
        var wareHouse =  new WareHouse(1L, manager, Collections.emptyList());
        var sector = new Sector(1L, "Carne",
                12,
                Collections.emptyList(),
                wareHouse );
        var inBoundOrder = new InBoundOrder(1, new Date(), Collections.emptyList(), sector );

//         var convertDto = new InBoundOrder( dto);
//        var inbound = new InBoundOrder();
//        when(inBoundOrderRepo.save(any(InBoundOrder.class))).thenReturn(inBoundOrder);
//        when(inBoundOrderRepo.findById(anyLong())).thenReturn(Optional.of(inBoundOrder));

//        when(inBoundOrderRepo.findById(anyLong())).thenReturn(Optional.of(inbound));
//        var service = new InBoundOrderImpService(inBoundOrderRepo, batchStockRepo, sectorRepo, productRepo);
//        var inBoundOrderResponseDTO = service.saveInBoundOrder(dto);




    }

    @Test
    void updateInBoundOrder() {
    }
}