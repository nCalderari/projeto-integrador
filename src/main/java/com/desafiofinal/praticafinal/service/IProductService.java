package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.model.Product;

public interface IProductService {
    Product saveProduct(ProductDTO product);
}
