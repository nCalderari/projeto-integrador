package com.desafiofinal.praticafinal.modelEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    @Id
    private long managerId;
    private String managerName;

    @OneToOne
    private WareHouse wareHouse;
}
