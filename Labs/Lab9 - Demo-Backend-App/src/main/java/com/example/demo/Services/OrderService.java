package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Models.Order;
import com.example.demo.Models.OrderItems;
import com.example.demo.Repos.OrderItemsRepository;
import com.example.demo.Repos.OrderRepository;

@Service
public class OrderService 
{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    // Use @Transactional on service methods that require access to entities outside the original transactional context to avoid LazyInitializationException
    @Transactional
    public void printOrderWithTotalCost(String buyerEmail) 
    {
        // Fetch all orders by user email
        List<Order> orders = orderRepository.findOrdersByUserEmail(buyerEmail);

        // Loop through each order and calculate total cost
        orders.forEach(order -> {
            // Fetch items for this order
            List<OrderItems> orderItems = orderItemsRepository.findByOrderId(order.getId());
            
            // Calculate total cost
            double totalCost = orderItems.stream()
                                         .mapToDouble(item -> item.getQuantity() * item.getPriceAtOrder())
                                         .sum();

            // Print the order details
            System.out.println("Order ID: " + order.getId());
            System.out.println("Total Cost: $" + totalCost);
            orderItems.forEach(item -> System.out.println(item.getSellerProduce().getProduce().getName() 
                                                          + ": " + item.getQuantity() 
                                                          + " @ $" + item.getPriceAtOrder()));
        });
    }
}
