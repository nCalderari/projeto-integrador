package com.desafiofinal.praticafinal.service;


import com.desafiofinal.praticafinal.dto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.model.InBoundOrder;

public interface IinboundOrderService {
    InBoundOrder saveInBoundOrder(InBoundOrder newOrder);
    InBoundOrder updateInBoundOrder(InBoundOrder updateOrder);
}
