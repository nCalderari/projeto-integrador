package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Manager;
import com.desafiofinal.praticafinal.model.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
