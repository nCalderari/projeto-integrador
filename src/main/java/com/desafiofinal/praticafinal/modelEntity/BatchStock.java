package com.desafiofinal.praticafinal.modelEntity;

import java.util.Date;

public class BatchStock {
    private long batchId;
    private String productId;
    private float currentTemperature;
    private float minimumTemperature;
    private long initialQuantity;
    private long currentQuantity;
    private Date manufacturingDate;
    private Date manufacturingTime;
    private Date dueDate;
}
