package com.desafiofinal.praticafinal.service;


import com.desafiofinal.praticafinal.dto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;

public interface IinboundOrderService {
    InBoundOrderResponseDTO saveInBoundOrder(InboundOrderRequestDTO newOrder) throws Exception;
    InBoundOrderResponseDTO updateInBoundOrder(InboundOrderRequestDTO updateOrder) throws Exception;
}
