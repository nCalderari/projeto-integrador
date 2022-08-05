package com.desafiofinal.praticafinal.modelEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sector {
    @Id
    private long sectorId;
    private String category;
    private double capacity;

    @OneToMany(mappedBy = "sector", cascade = CascadeType.REFRESH)
    private List<InBoundOrder> orderList;

    @ManyToOne
    private WareHouse wareHouse;
}
