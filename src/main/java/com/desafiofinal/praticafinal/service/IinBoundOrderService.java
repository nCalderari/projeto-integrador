package com.desafiofinal.praticafinal.service;


import com.desafiofinal.praticafinal.dto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;

public interface IinBoundOrderService {
    InBoundOrderResponseDTO saveInBoundOrder(InboundOrderRequestDTO newOrder) throws Exception;
    InBoundOrderResponseDTO updateInBoundOrder(InboundOrderRequestDTO updateOrder) throws Exception;
}
