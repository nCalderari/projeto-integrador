package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<Product, Long> {
    @Query
    public Product listProdutct();
}
