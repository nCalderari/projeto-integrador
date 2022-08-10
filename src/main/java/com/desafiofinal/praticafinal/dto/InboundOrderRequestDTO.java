package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.InBoundOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrderRequestDTO {

    private long orderId;
    private Date dateTime;
    private SectorDTO sector;

    private List<BatchStockDTO> batchStockList;


//    public static InBoundOrder convertDTOToInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO) {
//        return InBoundOrder.builder()
//                .orderId(inboundOrderRequestDTO.getOrderId())
//                .dateTime(inboundOrderRequestDTO.getDateTime())
//                .build();
//    }

}
