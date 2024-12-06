package com.example.demo.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.Models.OrderItems;


public interface OrderItemsRepository extends CrudRepository<OrderItems,Long>
{
    @Query("SELECT oi FROM OrderItems oi WHERE oi.order.id = :orderId")
    List<OrderItems> findByOrderId(@Param("orderId") Long orderId);
}