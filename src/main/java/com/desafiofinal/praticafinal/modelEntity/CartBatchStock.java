package com.desafiofinal.praticafinal.modelEntity;

import com.desafiofinal.praticafinal.modelDto.BuyerDto;
import com.desafiofinal.praticafinal.modelDto.CartBatchStockDto;
import com.desafiofinal.praticafinal.modelDto.CartDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.stream.Collectors;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartBatchStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartBatchStockId;

    @ManyToOne
    @JoinColumn(name = "id_cart")
    private Cart idCart;

    @ManyToOne
    @JoinColumn(name = "id_batchStock")
    private BatchStock batchStock;

    private double pricePerProduct;

    private int productQuantity;


}
