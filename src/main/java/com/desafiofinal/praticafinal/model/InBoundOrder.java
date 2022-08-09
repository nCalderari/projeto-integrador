package com.desafiofinal.praticafinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InBoundOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    private Date dateTime;

    @OneToMany (mappedBy = "inBoundOrder", cascade = CascadeType.PERSIST)
    private List<BatchStock> batchStockList;

    @ManyToOne
    @JoinColumn (name = "id_sector")
    @JsonIgnoreProperties("orderList")
    private Sector sector;

}