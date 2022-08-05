package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.modelEntity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {
}
