package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
