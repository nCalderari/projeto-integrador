package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.dto.BatchStockSectorDTO;
import com.desafiofinal.praticafinal.model.BatchStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBatchStockRepo extends JpaRepository<BatchStock, Long> {

    @Query(value = "SELECT batch.batch_id, batch.current_quantity, s.sector_id, batch.due_date FROM batch_stock as batch\n" +
            "join in_bound_order on batch.id_inboundorder = in_bound_order.order_id\n" +
            "join sector as s on in_bound_order.id_sector = s.sector_id\n" +
            "where id_product = ?1", nativeQuery = true)
    List<BatchStockSectorDTO> getListBatchSector(long id);

    @Query(value = "SELECT batch.batch_id, batch.current_quantity, s.sector_id, batch.due_date FROM batch_stock \n" +
            "join in_bound_order on batch_stock.id_inboundorder = in_bound_order.order_id\n" +
            "join sector on in_bound_order.id_sector = sector.sector_id\n" +
            "where id_product = ?1\n" +
            "order by batch_stock.batch_id;", nativeQuery = true)
    List<BatchStockSectorDTO> getListOrderedById(long id);

    @Query(value = "SELECT batch.batch_id, batch.current_quantity, s.sector_id, batch.due_date FROM batch_stock \n" +
            "join in_bound_order on batch_stock.id_inboundorder = in_bound_order.order_id\n" +
            "join sector on in_bound_order.id_sector = sector.sector_id\n" +
            "where id_product = ?1\n" +
            "order by batch_stock.current_quantity;", nativeQuery = true)
    List<BatchStockSectorDTO> getListOrderedByQuantity(long id);

    @Query(value = "SELECT batch.batch_id, batch.current_quantity, s.sector_id, batch.due_date FROM batch_stock \n" +
            "join in_bound_order on batch_stock.id_inboundorder = in_bound_order.order_id\n" +
            "join sector on in_bound_order.id_sector = sector.sector_id\n" +
            "where id_product = ?1\n" +
            "order by batch_stock.due_date", nativeQuery = true)
    List<BatchStockSectorDTO> getListOrderedByDueDate(long id);


}
