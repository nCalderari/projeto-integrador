package com.desafiofinal.praticafinal.modelDto;

import com.desafiofinal.praticafinal.modelEntity.Buyer;
import com.desafiofinal.praticafinal.modelEntity.Cart;
import com.desafiofinal.praticafinal.modelEntity.CartBatchStock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private int cartId;


    private BuyerDto buyer;

    private double totalPrice;

    private LocalDate date;

    private String orderStatus;

    private List<CartBatchStockDto> listCartBatchStock;

    public CartDto(Cart cart){
        this.cartId=cart.getCartId();
        this.buyer=new BuyerDto(cart.getBuyer());
        this.totalPrice=cart.getTotalPrice();
       // this.listCartBatchStock=cart.getListCartBatchStock();

    }

    public static Cart convertDtoToCart (CartDto cartDto){
        return Cart.builder()
                .buyer(BuyerDto.convertDtoToBuyer(cartDto.getBuyer()))
                .totalPrice(cartDto.getTotalPrice())
                .date(cartDto.getDate())
           //    .listCartBatchStock(cartDto.getListCartBatchStock())
                .build();
    }
}
