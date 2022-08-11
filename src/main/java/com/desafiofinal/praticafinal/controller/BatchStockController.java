package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.BatchStockDTO;
import com.desafiofinal.praticafinal.dto.BatchStockSectorDTO;
import com.desafiofinal.praticafinal.dto.requestResponseDto.BatchStockResponseDto;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.service.BatchStockImpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/sectorProducts")
public class BatchStockController {

    @Autowired
    private BatchStockImpService service;

    @GetMapping("/{productId}")
    ResponseEntity<List<BatchStockSectorDTO>> getBatchSector(@PathVariable long productId) throws Exception {
        List<BatchStockSectorDTO> getResponse = service.listBatchSector(productId);
        return new ResponseEntity<>(getResponse, HttpStatus.OK);
    }

    @GetMapping("/{productId}/{string}")
    ResponseEntity<List<BatchStockSectorDTO>> getBatchSectorOrdered(@PathVariable long productId, @PathVariable String string) throws Exception {
        List<BatchStockSectorDTO> getResponse = service.ListBatchSectorOrdered(productId, string);
        return new ResponseEntity<>(getResponse, HttpStatus.OK);
    }
}
