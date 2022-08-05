package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.modelEntity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepo extends JpaRepository<Manager, Long> {
}
