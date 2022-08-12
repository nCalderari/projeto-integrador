package com.desafiofinal.praticafinal.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.model.Cart;
import com.desafiofinal.praticafinal.repository.BuyerRepo;
import com.desafiofinal.praticafinal.repository.CartBatchStockRepo;
import com.desafiofinal.praticafinal.repository.IBatchStockRepo;
import com.desafiofinal.praticafinal.Builder.BatchStockBuilder;
import com.desafiofinal.praticafinal.Builder.BuyerBuilder;
import com.desafiofinal.praticafinal.Builder.CartBuilder;
import org.mockito.junit.jupiter.MockitoExtension;;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
    

    @InjectMocks
    private CartImpService cartService; 

    @Mock
    private BuyerRepo buyerRepo;

    @Mock
    private IBatchStockRepo batchStockRepo;
    

    @Test
    @DisplayName("Test if a buyer is found")
    void createPurchaseTest() {
    //    Buyer buyerTest = new Buyer(1l, "testadora da silva", Collections.emptySet()); 
       // Como o model tem o @Builder eu teoricamente não precisaria fazer o builder na mão, mas ai eu vou precisar
       // colocar uma lista de cart ali, e fazendo um builder eu posso fazer um sem o cart e usar esse 
       
       when(buyerRepo.findById(anyLong())).thenReturn(Optional.of(BuyerBuilder.aBuyerWithoutCart().create()));
       when(batchStockRepo.findById(anyLong())).thenReturn(Optional.of(BatchStockBuilder.aBatchStock().create()));
       
       Cart cart = CartBuilder.aCartWhithoutBuyer().create();

       Double total = cartService.createPurchase(cart);

       assertThat(total).isNotNull();
    //    assertThat(total).isDouble();  // ver se existe mesmo um is double

    //    Buyer buyer = BuyerBuilder.aBuyerWithoutCart().create();
        
    }

    // verificar e mockar as dependencias
    // chamar o metodo de create purchase passando um cart
    // fazer os asserts: conferir valor, se retorna double, 
    
}
