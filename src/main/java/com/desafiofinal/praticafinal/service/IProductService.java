package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ProductDTOWithSeller;
import com.desafiofinal.praticafinal.dto.requestResponseDto.ProductDTO;
import com.desafiofinal.praticafinal.dto.requestResponseDto.ProductResponseDTO;

import java.util.List;

public interface IProductService {
    ProductDTOWithSeller saveProduct(ProductDTOWithSeller product);

    List<ProductDTO> listAllProducts();

    List<ProductResponseDTO> listProductsByCategory(String category) throws Exception;
}
