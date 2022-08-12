package com.desafiofinal.praticafinal.dto.queryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


public interface BatchStockSectorDTO {

    Long getBatchId();
    Long getCurrentQuantity();
    Long getSectorId();
    LocalDate getDueDate();

}
