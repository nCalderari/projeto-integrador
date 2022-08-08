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

/**
 * This class holds all endpoints related to inbound orders
 * @author Monica, Yago, Marina, Amanda
 * @version 1.0.1
 * @see <a href="https://br-playground.digitalhouse.com/course/86ba8e00-da33-420a-a62a-02d4a77c55e8/unit/f1c410da-fa91-44a9-b216-b6b93b85246c/lesson/39480008-71db-4c4a-af64-12766a2245a7/topic/21261b7d-ee61-46cc-b8e3-ab7dffec542f"> Requirement 1 User Story Contracts</a>
 */


@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
public class InBoundOrderController {
    @Autowired
    private InBoundOrderImpService service;

    /**
     * Route used to insert into the datavase a new inbound order
     * @param newOrder A list containing: orderId (Long); Date(dateTime); Sector(String) and batchStockList(List)
     * @return  HTML Response 201: Created
     * @throws Exception ElementAlreadyExistException 
     */

    @PostMapping("/insert")
    public ResponseEntity<InBoundOrderResponseDto> create(@RequestBody InBoundOrderRequestDto newOrder) throws Exception {
        InBoundOrderResponseDto response = service.saveInBoundOrder(newOrder);

        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }
    
    /**
     * Route used to update inbound orders that already exists in the database
     * @param updateOrder A list containing: orderId (Long); Date(dateTime); Sector(String) and batchStockList(List)
     * @return HTML Response 204: Updated
     * @throws Exception ElementNotFoundException
     */
    @PutMapping("/update")
    public ResponseEntity<InBoundOrderResponseDto> updateInBoundOrder(@RequestBody InBoundOrderRequestDto updateOrder) throws Exception {
        InBoundOrderResponseDto updatedResponse = service.updateInBoundOrder(updateOrder);

        return new ResponseEntity<>(updatedResponse, HttpStatus.CREATED);

    }
}


