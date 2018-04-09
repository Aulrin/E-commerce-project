package com.niit.shopingcart.domain;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component //to create instance, same as class name but first letter small
@Entity //simple pojo class or model class,to specify it is not normal class- it is database entry
public class Cart {
	@Id    //to specify that it is primary key
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String emailID;
	private String productName;
	private int price;
	private int quantity;
	private String productID;
	
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Transient     ///we are not going persist/save this data in table.
	private int total;
	
	
	public int getId() {
		return id;
	}
	public void setId() {
		this.id = new Random().nextInt();
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
