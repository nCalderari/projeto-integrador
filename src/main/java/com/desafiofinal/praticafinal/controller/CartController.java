package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.CartDto;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.dto.requestResponseDto.BatchStockResponseDto;
import com.desafiofinal.praticafinal.model.Cart;
import com.desafiofinal.praticafinal.service.ICartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/purchases")
public class CartController {

    private final ICartService service;
    public CartController(ICartService service) {
        this.service = service;
    }

    @PostMapping("/insert")
    ResponseEntity<Double> createNewCart(@RequestBody CartDto cartDto) {
        Cart newCart = CartDto.convertDtoToCart(cartDto);
        return new ResponseEntity<>(service.createPurchase(newCart), HttpStatus.CREATED);
    }
    @GetMapping("/ListProducts/{purchaseId}")
    ResponseEntity<List<BatchStockResponseDto>> getProducts(@PathVariable long purchaseId){
        List<BatchStock> getResponse = service.getProducts(purchaseId);
        List<BatchStockResponseDto> getResponseDto = BatchStockResponseDto.convertToListDto(getResponse);
        return new ResponseEntity<>(getResponseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{purchaseId}")
    ResponseEntity<String> updateStatus (@PathVariable long purchaseId) throws Exception {
        String responseCart = service.updateStatus(purchaseId);
        return new ResponseEntity<>(responseCart, HttpStatus.CREATED); //TODO cartBatchStock não pode ter dois batchStocks iguais -> Pde sim, o prof ja falou!
    }
}