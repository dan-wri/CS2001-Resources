package com.example.demo.Models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "SellerProduce")
@EntityListeners(AuditingEntityListener.class)
public class Produce implements Serializable 
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @NotBlank
	int quantity;

    @NotBlank
	float priceAtOrder;

    @OneToMany(mappedBy = "sellerProduce", cascade=CascadeType.ALL)
	private List<OrderItems> orderItems;

    // Default constructor
    public Produce() 
    {
        super();
    }

    // Constructor with user
    public Produce(Order order, int quantity, float priceAtOrder) 
    {
        super();
        this.order = order;
        this. quantity = quantity;
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
        return "OrderItems [id=" + id + ", order=" + (order != null ? order.getId() : "null") + ", quantity=" + quantity + ", priceAtOrder=" + priceAtOrder + "]";
    }
}
