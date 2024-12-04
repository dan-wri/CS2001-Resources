package com.example.demo.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Orders")
@EntityListeners(AuditingEntityListener.class)
public class Order implements Serializable 
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = false) // Updated to be consistent with User class
    private User user;

    @OneToMany(mappedBy = "order", cascade=CascadeType.ALL)
	private List<OrderItems> orderItems;

    // Default constructor
    public Order() 
    {
        super();
    }

    // Constructor with user
    public Order(User user) 
    {
        this.user = user;
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

    public Date getDate() 
    {
        return date;
    }

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public User getUser() 
    {
        return user;
    }

    public void setUser(User user) 
    {
        this.user = user;
    }

    @Override
    public String toString() 
    {
        return "Order [id=" + id + ", date=" + date + ", user=" + (user != null ? user.getId() : "null") + "]";
    }
}
