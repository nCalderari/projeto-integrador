package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.SectorDTO;
import com.desafiofinal.praticafinal.dto.SellerDTO;
import com.desafiofinal.praticafinal.model.Seller;
import com.desafiofinal.praticafinal.repository.ISellerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class SellerImplServiceTest {
    @Mock
    private  ISellerRepo sellerRepo;

    @Test
     void saveSeller(){
        Seller seller = new Seller(  1L, "AMANDA", Collections.emptySet());

        when(sellerRepo.save(any(Seller.class))).thenReturn(seller);

        var service = new SellerImplService(sellerRepo);
        var sellerCreated = service.saveSeller(new SellerDTO(Optional.empty(), "amanda"));
        Assertions.assertEquals(seller.getSellerName(), sellerCreated.getSellerName());
    }

}
