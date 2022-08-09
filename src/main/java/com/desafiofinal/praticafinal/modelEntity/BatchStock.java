package com.desafiofinal.praticafinal.modelEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long batchId;

    private float currentTemperature;
    private float minimumTemperature;
    private long initialQuantity;
    private long currentQuantity;
    private Date manufacturingDate;
    private Date manufacturingTime;
    private Date dueDate;

    @ManyToOne
    @JoinColumn (name = "id_inboundorder")
    @JsonIgnoreProperties("batchStockList")
    private InBoundOrder inBoundOrder;

    @ManyToOne (cascade = CascadeType.REFRESH)
    @JsonIgnoreProperties("batchList")
    @JoinColumn (name = "id_product")
    private Product product;

    @OneToMany (mappedBy = "idBatchStock", cascade = CascadeType.REFRESH)
    private List<CartBatchStock> cartBatchStockList;

}
