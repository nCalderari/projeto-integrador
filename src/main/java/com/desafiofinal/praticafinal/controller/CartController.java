package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.CartDto;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.dto.requestResponseDto.BatchStockResponseDto;
import com.desafiofinal.praticafinal.service.CartImpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class holds all endpoints related to the shopping cart
 * @author Yago, Mônica, Marina
 * @version 1.0.1
 * @see  Requirement 2 docs: https://br-playground.digitalhouse.com/course/86ba8e00-da33-420a-a62a-02d4a77c55e8/unit/f1c410da-fa91-44a9-b216-b6b93b85246c/lesson/c3a563c4-4b77-4376-9030-56b3da54760c/topic/2825aaaf-c58e-43b2-821b-a68a11fda27b
 */

@RestController
@RequestMapping("/api/v1/fresh-products/purchases")
public class CartController {
    @Autowired
    CartImpService service;

    /**
     * Route used to create a new cart 
     * @param cart A list containing: CartId(Long), Buyer(BuyerId and Name), TotalPrice(Double), LocalDate(Date), OrderStatus(String) and batchStockList(List);
     * @return HTML Response 201: Created
     * @throws Exception
     */

    @PostMapping("/insert")
    ResponseEntity<Double> createNewCart(@RequestBody CartDto cart) throws Exception {
        return new ResponseEntity<Double>(service.createPurchase(cart), HttpStatus.CREATED);
    }

    /**
     * Route used to find products using the id that comes as a param
     * @param purchaseId A long number
     * @return HTML Response 201: Created
     * @throws Exception
     */

    @GetMapping("/ListProducts/{purchaseId}")
    ResponseEntity<List<BatchStockResponseDto>> getProducts(@PathVariable long purchaseId){
        List<BatchStock> getResponse = service.getProducts(purchaseId);
        List<BatchStockResponseDto> getResponseDto = BatchStockResponseDto.convertToListDto(getResponse);
        return new ResponseEntity<>(getResponseDto, HttpStatus.OK); //TODO utilizar productResponseDto e refatorar ele para response ao cliente
    }

    /**
     * Route used to add the selected product into the user's cart.
     * @param purchaseId A long number
     * @return HTML Response 201: Created
     * @throws Exception
     */
    @PutMapping("/update/{purchaseId}")
    ResponseEntity<String> updateStatus (@PathVariable long purchaseId) throws Exception {
        String responseCart = service.updateStatus(purchaseId);
        return new ResponseEntity<>(responseCart, HttpStatus.CREATED); //TODO cartBatchStock não pode ter dois batchStocks iguais
    }
}