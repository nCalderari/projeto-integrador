package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.model.BatchStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchStockRepo extends JpaRepository<BatchStock, Long> {
}
