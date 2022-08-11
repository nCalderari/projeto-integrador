package com.desafiofinal.praticafinal.dto.queryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchStockSectorDTO {

    private Long batchId;
    private Long currentQuantity;

    private Long sectorId;
    private LocalDate dueDate;
    private String category;
    private long productId;
    private long inBoundOrderId;
}
