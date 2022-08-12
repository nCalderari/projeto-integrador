package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.dto.SectorDTO;
import com.desafiofinal.praticafinal.dto.SellerDTO;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Sector;
import com.desafiofinal.praticafinal.service.ISectorservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fresh-products/sector")
public class SectorController {

    private ISectorservice sectorservice;

    public SectorController(ISectorservice sectorservice) {
        this.sectorservice = sectorservice;
    }

    @PostMapping
    public ResponseEntity<Object> insertProduct(@RequestBody SectorDTO sectordto){
        Sector response = sectorservice.saveSector(sectordto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
