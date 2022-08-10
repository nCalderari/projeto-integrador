package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Buyer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerDto {

    private long buyerId;

    private String buyerName;

    private List<CartDto> cartList;

    public BuyerDto (Buyer buyer){
        this.buyerId= buyer.getBuyerId();
        this.buyerName=buyer.getBuyerName();
        this.cartList=buyer.getCartList().stream().map(CartDto::new).collect(Collectors.toList());

    }

    public static Buyer convertDtoToBuyer (BuyerDto buyerDto){
        return Buyer.builder()
                .buyerName(buyerDto.getBuyerName())
                .cartList(buyerDto.getCartList().stream().map(CartDto::convertDtoToCart).collect(Collectors.toList()))
                .build();
    }

}
