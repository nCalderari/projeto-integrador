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

    private Date dateTime;

    @OneToMany (mappedBy = "inBoundOrderId", cascade = CascadeType.REFRESH)
    private List<BatchStock> batchStockList;

    @ManyToOne (cascade = CascadeType.REFRESH)
    @JoinColumn (name = "id_sector")
    private Sector sector;

}
