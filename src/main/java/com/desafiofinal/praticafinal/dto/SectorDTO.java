package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.model.Sector;
import com.desafiofinal.praticafinal.model.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectorDTO {

    private Long sectorId;
    private String category;
    private double capacity;
//    private List<InBoundOrder> orderList;//TODO retirar DTO
    private Long idWareHouse;

//    public SectorDTO(Sector sector) {
////        this.sectorId = sector.getSectorId();
//        this.category = sector.getCategory();
//        this.capacity = sector.getCapacity();
////        this.orderList = sector.getOrderList();
//        this.wareHouse = sector.getWareHouse();
//    }
}
