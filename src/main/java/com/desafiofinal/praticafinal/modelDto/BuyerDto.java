package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.Buyer;
import com.desafiofinal.praticafinal.modelEntity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerDto {

    private int buyerId;

    private String buyerName;

    private List<Cart> cartList;

    public BuyerDto (Buyer buyer){
        this.buyerId= buyer.getBuyerId();
        this.buyerName=buyer.getBuyerName();
        this.cartList=buyer.getCartList();
    }

    public static Buyer convertDtoToBuyer (BuyerDto buyerDto){
        return Buyer.builder()
                .buyerName(buyerDto.getBuyerName())
                .cartList(buyerDto.getCartList())
                .build();
    }
}
