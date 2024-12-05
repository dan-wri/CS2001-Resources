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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "SellerProduce")
@EntityListeners(AuditingEntityListener.class)
public class SellerProduce implements Serializable 
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produce_id", nullable = false)
    private Produce produce;

    @NotNull
	int quantity;

    @NotNull
	float price;

    @OneToMany(mappedBy = "sellerProduce", cascade=CascadeType.ALL)
	private List<OrderItems> orderItems;

    // Default constructor
    public SellerProduce() 
    {
        super();
    }

    // Constructor with user
    public SellerProduce(User user, Produce produce, int quantity, float price) 
    {
        super();
        this.user = user;
        this.produce = produce;
        this. quantity = quantity;
        this.price = price;
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

    public User user() 
    {
        return user;
    }

    public void setUser(User user) 
    {
        this.user = user;
    }

    public Produce produce() 
    {
        return produce;
    }

    public void setProduce(Produce produce) 
    {
        this.produce = produce;
    }

    public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

    public float getPrice() 
	{
		return price;
	}

	public void setPrice(float price) 
	{
		this.price = price;
	}

    @Override
    public String toString() 
    {
        return "OrderItems [id=" + id + ", seller_id=" + (user != null ? user.getId() : "null") + ", produce_id=" + (produce != null ? produce.getId() : "null") + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
