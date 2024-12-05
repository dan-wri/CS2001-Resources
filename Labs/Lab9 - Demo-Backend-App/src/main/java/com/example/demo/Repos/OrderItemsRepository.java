package com.example.demo.Repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Models.OrderItems;


public interface OrderItemsRepository extends CrudRepository<OrderItems,Long>
{
    
}