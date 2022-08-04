package com.desafiofinal.praticafinal.modelRequestResponseDto;

import com.desafiofinal.praticafinal.modelDto.BatchStockDto;
import com.desafiofinal.praticafinal.modelEntity.BatchStock;
import com.desafiofinal.praticafinal.modelEntity.InBoundOrder;
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

    private List<BatchStockDto> batchStockList;

    public InBoundOrderRequestDto (InBoundOrder inBoundOrder) {
        this.dateTime = inBoundOrder.getDateTime();
        this.orderId = inBoundOrder.getOrderId();
        this.batchStockList = inBoundOrder.getBatchStockList().stream().map(entity -> new BatchStockDto(entity)).collect(Collectors.toList());
    }
}