package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.CartDto;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.requestResponseDto.BatchStockResponseDto;
import com.desafiofinal.praticafinal.service.CartImpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/purchases")
public class CartController {
    @Autowired
    CartImpService service;

    @PostMapping("/insert")
    ResponseEntity<Double> createNewCart(@RequestBody CartDto cart) throws Exception {
        return new ResponseEntity<Double>(service.createPurchase(cart), HttpStatus.CREATED);
    }
    @GetMapping("/ListProducts/{purchaseId}")
    ResponseEntity<List<BatchStockResponseDto>> getProducts(@PathVariable long purchaseId){
        List<BatchStock> getResponse = service.getProducts(purchaseId);
        List<BatchStockResponseDto> getResponseDto = BatchStockResponseDto.convertToListDto(getResponse);
        return new ResponseEntity<>(getResponseDto, HttpStatus.OK); //TODO utilizar productResponseDto e refatorar ele para response ao cliente
    }

    @PutMapping("/update/{purchaseId}")
    ResponseEntity<String> updateStatus (@PathVariable long purchaseId) throws Exception {
        String responseCart = service.updateStatus(purchaseId);
        return new ResponseEntity<>(responseCart, HttpStatus.CREATED); //TODO cartBatchStock não pode ter dois batchStocks iguais
    }
}