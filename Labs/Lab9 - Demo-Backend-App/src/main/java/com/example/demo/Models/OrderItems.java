package com.example.demo.Models;

import java.io.Serializable;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "OrderItems")
@EntityListeners(AuditingEntityListener.class)
public class OrderItems implements Serializable 
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_produce_id", nullable = false)
    private Produce sellerProduce;

    @NotBlank
	int quantity;

    @NotBlank
	float priceAtOrder;

    // Default constructor
    public OrderItems() 
    {
        super();
    }

    // Constructor with user
    public OrderItems(Order order, Produce sellerProduce ,int quantity, float priceAtOrder) 
    {
        super();
        this.order = order;
        this.sellerProduce = sellerProduce;
        this.quantity = quantity;
        this.priceAtOrder = priceAtOrder;
    }

    // Getters and setters
    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Order getOrder() 
    {
        return order;
    }

    public void setOrder(Order order) 
    {
        this.order = order;
    }

    public Produce getSellerProduce() 
    {
        return sellerProduce;
    }

    public void setSellerProduce(Produce sellerProduce) 
    {
        this.sellerProduce = sellerProduce;
    }

    public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

    public float getPriceAtOrder() 
	{
		return priceAtOrder;
	}

	public void setPriceAtOrder(float priceAtOrder) 
	{
		this.priceAtOrder = priceAtOrder;
	}

    @Override
    public String toString() 
    {
        return "OrderItems [id=" + id + ", order=" + (order != null ? order.getId() : "null") + ", sellerProduce=" + (sellerProduce != null ? sellerProduce.getId() : "null") + ", quantity=" + quantity + ", priceAtOrder=" + priceAtOrder + "]";
    }
}
