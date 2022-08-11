package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.ISellerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ProductImplserviceTest {

    @Mock
    private  IProductRepo productRepo;
    @Mock
    private  ISellerRepo sellerRepo;


    @Test
    void saveProduct(){

        Seller seller =  new Seller(1L,"Seller", Collections.emptySet());
        Product product = new Product(1L,
                new Date(),
                14,
                "Carnes",
                "Patinho bovino",
                seller,
                24,
                Collections.emptyList());
        when(productRepo.save(any(Product.class))).thenReturn(product);
        when(sellerRepo.findById(anyLong())).thenReturn(Optional.ofNullable(seller));

        var service = new ProductImplService(productRepo, sellerRepo);
        var productCreated = service.saveProduct(new ProductDTO (
                "carme",
                "frios",
                new Date(),
                12,
                1L,
                17 ));


        Assertions.assertEquals(product.getProductName(), productCreated.getProductName());
    }
//todo teste lançando exceção
}
