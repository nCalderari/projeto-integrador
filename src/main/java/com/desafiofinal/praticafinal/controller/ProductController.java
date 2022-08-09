package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fresh-products/product")
public class ProductController {

    @Autowired
    private IProductService service;
//    public ProductController(IProductService service) {
//        this.service = service;
//    }

    @PostMapping
    public ResponseEntity<ProductDTO> insertProduct(@RequestBody ProductDTO product){
        ProductDTO response = service.saveproduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }



}
