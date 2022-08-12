package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.model.Cart;
import com.desafiofinal.praticafinal.model.Purchase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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

    private List<PurchaseDTO> listCartBatchStock;

    public CartDto(Cart cart){
        this.cartId=cart.getCartId();
        this.buyer = new BuyerDto(cart.getBuyer());
        this.totalPrice=cart.getTotalPrice();
    }

    public static Cart convertDtoToCart (CartDto cartDto){
        Buyer newBuyer = BuyerDto.convertDtoToBuyer(cartDto.getBuyer());
        List<Purchase> newPurchase = PurchaseDTO.convertToListEntity(cartDto.getListCartBatchStock());

        return Cart.builder()
                .cartId(cartDto.getCartId())
                .buyer(newBuyer)
                .totalPrice(cartDto.getTotalPrice())
                .date(cartDto.getDate())
                .orderStatus(cartDto.getOrderStatus())
                .listPurchase(newPurchase)
                .build();
    }
}
