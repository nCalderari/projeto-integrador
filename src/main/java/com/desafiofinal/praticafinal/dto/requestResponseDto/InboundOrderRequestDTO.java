package com.desafiofinal.praticafinal.dto.requestResponseDto;

import com.desafiofinal.praticafinal.dto.BatchStockDTO;
import com.desafiofinal.praticafinal.dto.SectorDTO;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrderRequestDTO {

    private long orderId;
    private LocalDate dateTime;
    private SectorDTO sector;

    private List<BatchStockDTO> batchStockList;

    public static InBoundOrder convertDTOToInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO) {
        return InBoundOrder.builder()
                .orderId(inboundOrderRequestDTO.getOrderId())
                .dateTime(inboundOrderRequestDTO.getDateTime())
                .sector(SectorDTO.convertToSector(inboundOrderRequestDTO.getSector()))
                .batchStockList(BatchStockDTO.convertToListEntity(inboundOrderRequestDTO.getBatchStockList()))
                .build();
    }

}
