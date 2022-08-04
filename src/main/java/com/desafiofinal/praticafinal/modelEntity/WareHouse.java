package com.desafiofinal.praticafinal.modelEntity;

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
public class WareHouse {
    @Id
    private long wareHouseId;

    @OneToMany(mappedBy = "wareHouse", cascade = CascadeType.REFRESH)
    private List<Sector> sectorList;
}
