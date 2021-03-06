package com.poisonedyouth.vault.demo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Convert(converter = TransitConverter.class)
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "product_name")
	private String productName;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date")
	@CreationTimestamp
	private Date orderDate;

	public Order(long id, String customerName, String productName, Date orderDate) {
		this.id = id;
		this.customerName = customerName;
		this.productName = productName;
		this.orderDate = orderDate;
	}

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setProductName(String name) {
		this.productName = name;
	}

	public String getProductName() {
		return productName;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	@Override
	public String toString() {
		return "Order{" + "id=" + id + ", Customer Name='" + customerName + '\'' + ", Product Name='" + productName + '\'' + ", Order Date="
				+ orderDate + '}';
	}

}
