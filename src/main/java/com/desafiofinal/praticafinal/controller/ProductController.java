package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.ProductDTOWithSeller;
import com.desafiofinal.praticafinal.dto.requestResponseDto.BatchStockResponseDto;
import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/product")
public class ProductController {

    private final IProductService service;
    public ProductController(IProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductDTOWithSeller> insertProduct(@RequestBody ProductDTOWithSeller product){
            ProductDTOWithSeller response = service.saveProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/products")
    ResponseEntity<List<ProductDTO>> getAllProducts(){

        return new ResponseEntity<List<ProductDTO>>(service.listAllProducts(),HttpStatus.FOUND);

    }


    @GetMapping("/{category}")
    ResponseEntity<List<BatchStockResponseDto>> getProductBySector(@PathVariable String category)throws Exception{
        return new ResponseEntity<List<BatchStockResponseDto>>(service.listBatchStockByCategory(category),HttpStatus.FOUND);
    }
}
