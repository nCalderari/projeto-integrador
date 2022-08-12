package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.dto.SectorDTO;
import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Sector;
import com.desafiofinal.praticafinal.model.Seller;
import com.desafiofinal.praticafinal.model.WareHouse;
import com.desafiofinal.praticafinal.repository.ISectorRepo;
import com.desafiofinal.praticafinal.repository.IWareHouseRepo;
import org.springframework.stereotype.Service;

@Service
public class SectorImpService  implements  ISectorservice{
   private final IWareHouseRepo wareHouseRepo;
   private final ISectorRepo sectorRepo;

    public SectorImpService(IWareHouseRepo wareHouseRepo, ISectorRepo sectorRepo) {
        this.wareHouseRepo = wareHouseRepo;
        this.sectorRepo = sectorRepo;
    }

    @Override
    public Sector saveSector(SectorDTO sectordto) {
       var wareHouse = wareHouseRepo
               .findById(sectordto.getIdWareHouse())
               .orElseThrow(() -> new ElementNotFoundException("Ware House does not exist"));

    Sector sectorSaved = sectorRepo.save(buildSector(sectordto, wareHouse) );
    return sectorSaved;
    }

    private Sector buildSector(SectorDTO sectordto, WareHouse wareHouse){
        return Sector.builder()
                .category(sectordto.getCategory())
                .capacity(sectordto.getCapacity())
                .wareHouse(wareHouse)
                .build();
    }
}
