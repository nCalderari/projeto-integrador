package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.Manager;
import com.desafiofinal.praticafinal.modelEntity.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDto {

    private long managerId;
    private String managerName;

    private WareHouse wareHouse;

    public ManagerDto (Manager manager){
        this.managerId=manager.getManagerId();
        this.managerName=manager.getManagerName();
        this.wareHouse=manager.getWareHouse();
    }
}
