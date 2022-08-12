package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartBatchStockRepo extends JpaRepository<Purchase, Long> {
}
