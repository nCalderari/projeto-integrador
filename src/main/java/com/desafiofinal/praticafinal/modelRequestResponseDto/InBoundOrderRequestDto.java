package com.desafiofinal.praticafinal.modelRequestResponseDto;

import com.desafiofinal.praticafinal.modelDto.BatchStockDto;
import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import com.desafiofinal.praticafinal.modelEntity.InBoundOrder;
import com.desafiofinal.praticafinal.modelEntity.Sector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InBoundOrderRequestDto {

    private long orderId;
    private Date dateTime;
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