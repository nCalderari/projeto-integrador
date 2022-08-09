package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.Buyer;
import com.desafiofinal.praticafinal.modelEntity.Cart;
import com.desafiofinal.praticafinal.modelEntity.InBoundOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerDto {

    private int buyerId;

    private String buyerName;

    private List<CartDto> cartList;

    public BuyerDto (Buyer buyer){
        this.buyerId= buyer.getBuyerId();
        this.buyerName=buyer.getBuyerName();
        this.cartList=buyer.getCartList().stream().map(ca -> new CartDto(ca)).collect(Collectors.toList());

    }

    public static Buyer convertDtoToBuyer (BuyerDto buyerDto){
        return Buyer.builder()
                .buyerName(buyerDto.getBuyerName())
                .cartList(buyerDto.getCartList().stream().map(dto -> CartDto.convertDtoToCart(dto)).collect(Collectors.toList()))
                .build();
    }

}
