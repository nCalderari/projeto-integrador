package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.SellerDTO;
import com.desafiofinal.praticafinal.model.Seller;
import com.desafiofinal.praticafinal.repository.ISellerRepo;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SellerImplService implements ISellerService{
    private final ISellerRepo repo;

    public SellerImplService(ISellerRepo repo) {
        this.repo = repo;
    }

    @Override
    public SellerDTO saveSeller(SellerDTO seller) {
        val sellerSaved = repo.save(seller.toEntity());
        var sellerConverted = new SellerDTO(sellerSaved);
        return sellerConverted;
    }
}
