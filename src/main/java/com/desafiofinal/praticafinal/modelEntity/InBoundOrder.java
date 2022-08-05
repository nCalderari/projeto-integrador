package com.desafiofinal.praticafinal.modelEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InBoundOrder {
    @Id
    private long orderId;

    private Date dateTime;

    @OneToMany (mappedBy = "inBoundOrderId")
    private List<BatchStock> batchStockList;

    @ManyToOne
    private Sector sector;

}
