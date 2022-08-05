package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import org.springframework.data.repository.CrudRepository;


public interface BatchStockRepo extends CrudRepository <BatchStock, Long> {
}
