package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.ProductDTOWithSeller;
import com.desafiofinal.praticafinal.dto.requestResponseDto.ProductDTO;
import com.desafiofinal.praticafinal.dto.requestResponseDto.ProductResponseDTO;
import com.desafiofinal.praticafinal.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class holds all endpoints related to the product
 * @author Yago, Mônica, Marina
 * @version 1.0.0
 * @see Requirement 3 docs: https://br-playground.digitalhouse.com/course/86ba8e00-da33-420a-a62a-02d4a77c55e8/unit/f1c410da-fa91-44a9-b216-b6b93b85246c/lesson/6d242a1a-4961-4105-be9c-9189eb8eb6bc/topic/efd4119b-f679-48db-b77a-f7f18e0ca1c6
 */

@RestController
@RequestMapping("/api/v1/fresh-products/product")
public class ProductController {

    private final IProductService service;
    public ProductController(IProductService service) {
        this.service = service;
    }

    /**
     * This route creates a list of products alongside the seller information
     * @param product ProductName(String), ProductType(String), ValidateDate(LocalDate), Price(double), IdSeller(Long), Bulk(double).
     * @return HTML Response 201: Created
     */
    @PostMapping
    public ResponseEntity<ProductDTOWithSeller> insertProduct(@RequestBody ProductDTOWithSeller product){
            ProductDTOWithSeller response = service.saveProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * This route lists all products
     * @return HTML Response 201: Created
     */
    @GetMapping("/products")
    ResponseEntity<List<ProductDTO>> getAllProducts(){

        return new ResponseEntity<List<ProductDTO>>(service.listAllProducts(),HttpStatus.OK);

    }

    /**
     * This route lists all products from a specific category
     * @param category String containing the category name
     * @return HTML Response 201: Created
     * @throws Exception 
     */
    @GetMapping("/{category}")
    ResponseEntity<List<ProductResponseDTO>> getProductBySector(@PathVariable String category)throws Exception{
        return new ResponseEntity<List<ProductResponseDTO>>(service.listProductsByCategory(category),HttpStatus.OK);

    }
}
