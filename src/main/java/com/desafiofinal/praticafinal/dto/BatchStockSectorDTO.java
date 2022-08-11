package com.desafiofinal.praticafinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchStockSectorDTO {

    private long batchNumber;
    private long currentQuantity;
    private long sectorId;
    private LocalDate dueDate;
}
