package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.modelEntity.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseRepo extends JpaRepository<WareHouse, Long> {
}
