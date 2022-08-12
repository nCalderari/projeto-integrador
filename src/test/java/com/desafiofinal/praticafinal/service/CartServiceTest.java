package com.desafiofinal.praticafinal.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.model.Cart;
import com.desafiofinal.praticafinal.repository.BuyerRepo;
import com.desafiofinal.praticafinal.Builder.BuyerBuilder;;

public class CartServiceTest {
    

    @InjectMocks
    private CartImpService cartService; 

    @Mock
    private BuyerRepo buyerRepo;

    @Test
    @DisplayName("Test if a buyer is found")
    void createPurchaseTest() {
    //    Buyer buyerTest = new Buyer(1l, "testadora da silva", Collections.emptySet()); 
       // Como o model tem o @Builder eu teoricamente não precisaria fazer o builder na mão, mas ai eu vou precisar
       // colocar uma lista de cart ali, e fazendo um builder eu posso fazer um sem o cart e usar esse 
       
       when(buyerRepo.findById(anyLong())).thenReturn(Optional.of(BuyerBuilder.aBuyerWithoutCart().create()));
       
       
    //    Buyer buyer = BuyerBuilder.aBuyerWithoutCart().create();
    //    when(buyerRepo.findOne(any(Buyer.class))) // ja tentei com exists e findOne e n vai
    }

    // verificar e mockar as dependencias
    // chamar o metodo de create purchase passando um cart
    // fazer os asserts: conferir valor, se retorna double, 
    
}
