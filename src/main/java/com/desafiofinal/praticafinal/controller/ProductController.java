package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.requestResponseDto.BatchStockResponseDto;
import com.desafiofinal.praticafinal.dto.requestResponseDto.ProductDTO;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.service.IBatchStockService;
import com.desafiofinal.praticafinal.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/product")
public class ProductController {

    private final IProductService service;
    private final IBatchStockService batchStockService;
    public ProductController(IProductService service, IBatchStockService batchStockService) {
        this.service = service;
        this.batchStockService = batchStockService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insertProduct(@RequestBody ProductDTO productDTO){
        Product newProduct = ProductDTO.convertDtoToProduct(productDTO);
        Product response = service.saveProduct(newProduct);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(response));
    }

    @GetMapping("/products")
    ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> response = ProductDTO.convertToDTO(service.listAllProducts());
        return new ResponseEntity<List<ProductDTO>>(response, HttpStatus.FOUND);

    }

    @GetMapping("/{category}")
    ResponseEntity<List<BatchStockResponseDto>> getProductBySector(@PathVariable String category)throws Exception{
        List<BatchStock> response = batchStockService.listBatchStockByCategory(category);
        return new ResponseEntity<List<BatchStockResponseDto>>(BatchStockResponseDto.convertToListDto(response),HttpStatus.FOUND);
    }
}
