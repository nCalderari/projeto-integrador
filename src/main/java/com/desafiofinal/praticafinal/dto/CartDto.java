package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private long cartId;

    private long buyer;

    private double totalPrice;

    private LocalDate date;

    private String orderStatus;

    private List<CartBatchStockDto> listCartBatchStock;

    public CartDto(Cart cart){
        this.cartId=cart.getCartId();
        this.buyer= cart.getBuyer().getBuyerId();
        this.totalPrice=cart.getTotalPrice();
//        this.listCartBatchStock=cart.getListCartBatchStock().stream().map(car -> new CartBatchStockDto(car)).collect(Collectors.toList());
    }

    public static Cart convertDtoToCart (CartDto cartDto){
        return Cart.builder()
                .totalPrice(cartDto.getTotalPrice())
                .date(cartDto.getDate())
                .listCartBatchStock(cartDto.getListCartBatchStock().stream().map(CartBatchStockDto::convertDtoToCartBatchStock).collect(Collectors.toList()))
                .build();
    }
}
