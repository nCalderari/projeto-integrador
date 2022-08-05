package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.modelEntity.InBoundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InBoundOrderRepo extends JpaRepository<InBoundOrder, Long> {
}
