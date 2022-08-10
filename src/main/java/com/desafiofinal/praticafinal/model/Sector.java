package com.desafiofinal.praticafinal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sectorId;
    private String category;
    private double capacity;

    @OneToMany(mappedBy = "sector", cascade = CascadeType.REFRESH)
    private List<InBoundOrder> orderList;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_warehouse")
    private WareHouse wareHouse;
}
