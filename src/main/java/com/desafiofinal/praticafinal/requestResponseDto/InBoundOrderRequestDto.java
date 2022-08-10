package com.desafiofinal.praticafinal.requestResponseDto;

import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.model.Sector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InBoundOrderRequestDto {

    private long orderId;
    private LocalDate dateTime;
    private Sector sector;

    private List<BatchStock> batchStockList;

    public InBoundOrderRequestDto (InBoundOrder inBoundOrder) {
        this.dateTime = inBoundOrder.getDateTime();
        this.orderId = inBoundOrder.getOrderId();
        this.sector=inBoundOrder.getSector();
        this.batchStockList = inBoundOrder.getBatchStockList();

             //   .stream().map(entity -> new BatchStockDto(entity)).collect(Collectors.toList());
    }

    public static InBoundOrder convertDtoToInBoundOrder (InBoundOrderRequestDto inBoundOrderRequestDto){
        return InBoundOrder.builder()
                .orderId(inBoundOrderRequestDto.getOrderId())
                .dateTime(inBoundOrderRequestDto.getDateTime())
                .sector(inBoundOrderRequestDto.getSector())
                .batchStockList(inBoundOrderRequestDto.getBatchStockList())
                .build();
    }
}