package com.desafiofinal.praticafinal.Builder;

import com.desafiofinal.praticafinal.model.Buyer;

public class BuyerBuilder {

    private Buyer buyer;
    
    private BuyerBuilder(){}

    public static BuyerBuilder aBuyerWithoutCart() {
        BuyerBuilder builder = new BuyerBuilder();

        builder.buyer = new Buyer();
     
        builder.buyer.setBuyerId(1l);
        builder.buyer.setBuyerName("Testadora silva");
        builder.buyer.setCartList(null); // tiro ou deixo null?

        return builder;
    }

    public Buyer create() {
        return buyer;
    }
}
