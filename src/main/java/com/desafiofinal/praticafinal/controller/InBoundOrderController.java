package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.modelEntity.InBoundOrder;
import com.desafiofinal.praticafinal.modelRequestResponseDto.InBoundOrderRequestDto;
import com.desafiofinal.praticafinal.modelRequestResponseDto.InBoundOrderResponseDto;
import com.desafiofinal.praticafinal.service.IInBoundOrderService;
import com.desafiofinal.praticafinal.service.InBoundOrderImpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
public class InBoundOrderController {
    @Autowired
    private InBoundOrderImpService service;

    @PostMapping("/insert")
    public ResponseEntity<InBoundOrderResponseDto> create(@RequestBody InBoundOrderRequestDto newOrder) throws Exception {
        InBoundOrderResponseDto response = service.saveInBoundOrder(newOrder);

        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }

    @PutMapping("/update")
    public ResponseEntity<InBoundOrderResponseDto> updateInBoundOrder(@RequestBody InBoundOrderRequestDto updateOrder) throws Exception {
        InBoundOrderResponseDto updatedResponse = service.updateInBoundOrder(updateOrder);

        return new ResponseEntity<>(updatedResponse, HttpStatus.CREATED);

    }
}


