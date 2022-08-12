package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.SectorDTO;
import com.desafiofinal.praticafinal.dto.SellerDTO;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Sector;

public interface ISectorservice {
    Sector saveSector(SectorDTO sectordto);
}
