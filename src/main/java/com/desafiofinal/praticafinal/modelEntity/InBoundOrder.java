package com.desafiofinal.praticafinal.modelEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private Date orderDate;

    @OneToMany (mappedBy = "inBoundOrderId", cascade = CascadeType.PERSIST)
    private List<BatchStock> batchStockList;

    @ManyToOne
    @JoinColumn (name = "id_sector")
    private Sector sector;

}
