package com.desafiofinal.praticafinal.dto.queryDto;

import com.desafiofinal.praticafinal.model.BatchStock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


public interface BatchStockSectorDTO {

    Long getSectorId();
    Long getProductId();
    Long getBatchId();
    Long getCurrentQuantity();
    LocalDate getDueDate();
    String getCategory();


}
