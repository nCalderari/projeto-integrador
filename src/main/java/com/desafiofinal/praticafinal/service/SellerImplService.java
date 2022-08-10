package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.SellerDTO;
import com.desafiofinal.praticafinal.repository.ISellerRepo;
import lombok.val;
import org.springframework.stereotype.Service;


@Service
public class SellerImplService implements ISellerService{
    private final ISellerRepo repo;

    public SellerImplService(ISellerRepo repo) {
        this.repo = repo;
    }

    @Override
    public SellerDTO saveSeller(SellerDTO seller) {
        try{
            val sellerSaved = repo.save(seller.toEntity());
            return new SellerDTO(sellerSaved);
        }
       catch (Exception e){
            throw new Error("Desculpe, não foi possível realizar a sua solicitação", e.getCause());
       }
    }
}
