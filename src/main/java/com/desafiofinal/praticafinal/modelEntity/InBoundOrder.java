package com.desafiofinal.praticafinal.modelEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InBoundOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    private LocalDate dateTime;

    @OneToMany (mappedBy = "inBoundOrder", cascade = CascadeType.PERSIST)
    private List<BatchStock> batchStockList;

    @ManyToOne
    @JoinColumn (name = "id_sector")
    @JsonIgnoreProperties("orderList")
    private Sector sector;

}
