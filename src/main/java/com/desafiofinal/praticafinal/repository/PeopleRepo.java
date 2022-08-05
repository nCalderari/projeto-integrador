package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.modelEntity.Manager;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepo extends CrudRepository<Manager, Long> {
}
