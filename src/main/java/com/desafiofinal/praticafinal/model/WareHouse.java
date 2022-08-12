package com.desafiofinal.praticafinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"manager", "sectorList"})

public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wareHouseId;

    @OneToOne
    @JoinColumn(name = "id_manager")
    private Manager manager;

    @OneToMany(mappedBy = "wareHouse")
    @JsonIgnore
    private List<Sector> sectorList;

}
