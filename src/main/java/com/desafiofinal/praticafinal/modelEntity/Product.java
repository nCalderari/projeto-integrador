package com.desafiofinal.praticafinal.modelEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private long id;

    private String productType;

    private Date validateDate;

    private double price;

    private String productId;

    private String productName;

    @ManyToOne
    private Seller seller;

    private double bulk;

    @OneToMany (mappedBy = "product", cascade = CascadeType.REFRESH)
    private List<BatchStock> batchList;

}
