package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.modelEntity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Long> {
}
