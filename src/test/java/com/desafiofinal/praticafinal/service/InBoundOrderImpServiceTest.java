package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.BatchStockDTO;
import com.desafiofinal.praticafinal.dto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.dto.SectorDTO;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.repository.IBatchStockRepo;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.ISectorRepo;
import com.desafiofinal.praticafinal.repository.InBoundOrderRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Date;
import java.util.List;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.*;

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
        var dto = new InboundOrderRequestDTO(1, new Date(), new SectorDTO() );
//        var inbound = new InBoundOrder();
//        Mockito.when(inBoundOrderRepo.findById(1L)).thenReturn(of(inbound));

//        var service = new InBoundOrderImpService(inBoundOrderRepo, batchStockRepo, sectorRepo, productRepo);
//        var inBoundOrderResponseDTO = service.saveInBoundOrder(dto);




    }

    @Test
    void updateInBoundOrder() {
    }
}