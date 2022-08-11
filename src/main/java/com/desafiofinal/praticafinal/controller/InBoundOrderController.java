package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.service.IinboundOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

/**
 * This class holds all endpoints related to inbound orders
 * @author Monica, Yago, Marina, Amanda
 * @version 1.0.1
 * @see Requirement 1 docs: encurtador.com.br/pC189
 */

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
public class InBoundOrderController {
    @Autowired
    private IinboundOrderService service;

    /**
     * Route used to insert into the datavase a new inbound order
     * @param newOrder A list containing: orderId (Long); Date(dateTime); Sector(String) and batchStockList(List)
     * @return  HTML Response 201: Created
     * @throws Exception ElementAlreadyExistException 
     */

    @PostMapping("/insert")
    public ResponseEntity<InBoundOrderResponseDTO> create(@RequestBody InboundOrderRequestDTO newOrder) throws Exception {
        InBoundOrderResponseDTO response = service.saveInBoundOrder(newOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    
    /**
     * Route used to update inbound orders that already exists in the database
     * @param updateOrder A list containing: orderId (Long); Date(dateTime); Sector(String) and batchStockList(List)
     * @return HTML Response 204: Updated
     * @throws Exception ElementNotFoundException
     */
    @PutMapping("/update")
    public ResponseEntity<InBoundOrderResponseDTO> updateInBoundOrder(@RequestBody InboundOrderRequestDTO updateOrder) throws Exception {
        InBoundOrderResponseDTO updatedResponse = service.updateInBoundOrder(updateOrder);

        return new ResponseEntity<>(updatedResponse, HttpStatus.CREATED);

    }
}


