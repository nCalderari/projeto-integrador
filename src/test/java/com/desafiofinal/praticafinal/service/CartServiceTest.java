package com.desafiofinal.praticafinal.service;

import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.model.Cart;
import com.desafiofinal.praticafinal.repository.BuyerRepo;
import com.desafiofinal.praticafinal.Builder.BuyerBuilder;;

public class CartServiceTest {

    @Mock
    private BuyerRepo buyerRepo;

    @Test
    @DisplayName("Test if a buyer is found")
    void findBuyer() {
    //    Buyer buyerTest = new Buyer(1l, "testadora da silva", Collections.emptySet()); 
       // Como o model tem o @Builder eu teoricamente não precisaria fazer o builder na mão, mas ai eu vou precisar
       // colocar uma lista de cart ali, e fazendo um builder eu posso fazer um sem o cart e usar esse 
       Buyer buyer = BuyerBuilder.aBuyerWithoutCart().create();
    //    when(buyerRepo.findOne())
    }
    
}
