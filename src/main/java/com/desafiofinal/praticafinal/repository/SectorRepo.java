package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.modelEntity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepo extends JpaRepository<Sector, Long> {
}
