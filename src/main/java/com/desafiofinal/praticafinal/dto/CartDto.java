package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.model.Cart;
import com.desafiofinal.praticafinal.model.CartBatchStock;
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

    private BuyerDto buyer;

    private double totalPrice;

    private LocalDate date;

    private String orderStatus;

    private List<CartBatchStockDto> listCartBatchStock;

    public CartDto(Cart cart){
        this.cartId=cart.getCartId();
        this.buyer = new BuyerDto(cart.getBuyer());
        this.totalPrice=cart.getTotalPrice();
//        this.listCartBatchStock=cart.getListCartBatchStock().stream().map(car -> new CartBatchStockDto(car)).collect(Collectors.toList());
    }

    public static Cart convertDtoToCart (CartDto cartDto){
        Cart cart = new Cart();

        Buyer newBuyer = BuyerDto.convertDtoToBuyer(cartDto.getBuyer());
        List<CartBatchStock> newCartBatchStock = CartBatchStockDto.convertToListEntity(cartDto.getListCartBatchStock());
        cart.setBuyer(newBuyer);
        cart.setListCartBatchStock(newCartBatchStock);
        cart.setCartId(cartDto.getCartId());
        cart.setTotalPrice(cartDto.getTotalPrice());
        cart.setDate(cartDto.getDate());


        return cart;
    }
}
