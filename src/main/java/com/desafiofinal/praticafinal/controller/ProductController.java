package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.ProductDto;
import com.desafiofinal.praticafinal.service.ProductsImpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desafiofinal.praticafinal.requestResponseDto.ProductResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    @Autowired
    private ProductsImpService service;

    @GetMapping("/products")
        ResponseEntity<List<ProductDto>> getAllProducts(){

        return new ResponseEntity<List<ProductDto>>(service.listAllProducts(),HttpStatus.FOUND);

    }


    @GetMapping("/{category}")
    ResponseEntity<List<ProductResponseDto>> getProductBySector(@PathVariable String category)throws Exception{
        return new ResponseEntity<List<ProductResponseDto>>(service.listProductsByCategory(category),HttpStatus.FOUND);

    }
}
