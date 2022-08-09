package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.modelRequestResponseDto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.modelRequestResponseDto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.service.InBoundOrderImpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
public class InBoundOrderController {
    @Autowired
    private InBoundOrderImpService service;

    @PostMapping("/insert")
    public ResponseEntity<InBoundOrderResponseDTO> create(@RequestBody InboundOrderRequestDTO newOrder) throws Exception {
        InBoundOrderResponseDTO response = service.saveInBoundOrder(newOrder);

        return new ResponseEntity<InBoundOrderResponseDTO>(response, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<InBoundOrderResponseDTO> updateInBoundOrder(@RequestBody InboundOrderRequestDTO updateOrder) throws Exception {
        InBoundOrderResponseDTO updatedResponse = service.updateInBoundOrder(updateOrder);

        return new ResponseEntity<>(updatedResponse, HttpStatus.CREATED);

    }
}


