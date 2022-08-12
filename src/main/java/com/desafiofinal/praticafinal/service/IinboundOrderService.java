package com.desafiofinal.praticafinal.service;


import com.desafiofinal.praticafinal.dto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.model.InBoundOrder;

public interface IinboundOrderService {
    InBoundOrder saveInBoundOrder(InboundOrderRequestDTO newOrder) throws Exception;
    InBoundOrder updateInBoundOrder(InboundOrderRequestDTO updateOrder) throws Exception;
}
