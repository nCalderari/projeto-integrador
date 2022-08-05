package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import com.desafiofinal.praticafinal.modelEntity.Sector;
import com.desafiofinal.praticafinal.modelEntity.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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