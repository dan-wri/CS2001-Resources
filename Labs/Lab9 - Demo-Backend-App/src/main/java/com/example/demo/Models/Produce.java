package com.example.demo.Models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Produce")
@EntityListeners(AuditingEntityListener.class)
public class Produce implements Serializable 
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    String name;

    @OneToMany(mappedBy = "produce", cascade=CascadeType.ALL)
	private List<SellerProduce> SellerProduce;

    // Default constructor
    public Produce() 
    {
        super();
    }

    // Constructor with user
    public Produce(String name) 
    {
        super();
        this.name = name;
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

    public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

    @Override
    public String toString() 
    {
        return "OrderItems [id=" + id + ", name=" + name + "]";
    }
}