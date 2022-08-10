package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Sector;
import com.desafiofinal.praticafinal.model.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseDto {

    private long wareHouseId;
    private List<Sector> sectorList;

    public WareHouseDto(WareHouse wareHouse) {
        this.wareHouseId = wareHouse.getWareHouseId();
        this.sectorList = wareHouse.getSectorList();
    }

}