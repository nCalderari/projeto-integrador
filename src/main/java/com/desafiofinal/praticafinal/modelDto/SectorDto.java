package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.InBoundOrder;
import com.desafiofinal.praticafinal.modelEntity.Sector;
import com.desafiofinal.praticafinal.modelEntity.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectorDto {

    private long sectorId;
    private String category;
    private double capacity;
    private List<InBoundOrder> orderList;
    private WareHouse wareHouse;

    public SectorDto(Sector sector) {
        this.sectorId = sector.getSectorId();
        this.category = sector.getCategory();
        this.capacity = sector.getCapacity();
        this.orderList = sector.getOrderList();
        this.wareHouse = sector.getWareHouse();
    }
}
