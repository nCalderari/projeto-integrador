package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.modelDto.BatchStockDto;
import com.desafiofinal.praticafinal.modelDto.CartBatchStockDto;
import com.desafiofinal.praticafinal.modelDto.CartDto;
import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import com.desafiofinal.praticafinal.modelEntity.CartBatchStock;
import com.desafiofinal.praticafinal.service.CartImpService;
import org.apache.coyote.Response;
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
    ResponseEntity<List<BatchStockDto>> getProducts(@PathVariable long purchaseId){
        List<BatchStock> getResponse = service.getProducts(purchaseId);
        List<BatchStockDto> getResponseDto = BatchStockDto.convertToListDto(getResponse);
        return new ResponseEntity<>(getResponseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{purchaseId}/{status}")
    ResponseEntity<CartDto> updateStatus (@PathVariable long purchaseId, @PathVariable String status){
        CartDto responseCart = service.updateStatus(purchaseId, status);
        return new ResponseEntity<>(responseCart, HttpStatus.CREATED);
    }
}