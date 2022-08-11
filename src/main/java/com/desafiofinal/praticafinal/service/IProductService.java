package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ProductDTOWithSeller;
import com.desafiofinal.praticafinal.dto.requestResponseDto.BatchStockResponseDto;
import com.desafiofinal.praticafinal.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    ProductDTOWithSeller saveProduct(ProductDTOWithSeller product);

    List<ProductDTO> listAllProducts();

    List<BatchStockResponseDto> listBatchStockByCategory (String category)throws Exception;
}
