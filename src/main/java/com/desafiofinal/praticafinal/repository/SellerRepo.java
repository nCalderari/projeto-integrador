package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Long> {
}
