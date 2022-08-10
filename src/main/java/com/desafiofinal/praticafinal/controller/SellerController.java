package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.dto.SellerDTO;
import com.desafiofinal.praticafinal.service.ISellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fresh-products/seller")
public class SellerController {

    private final ISellerService service;

    public SellerController(ISellerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SellerDTO> insertSeller(@RequestBody SellerDTO seller){
        SellerDTO response = service.saveSeller(seller);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
