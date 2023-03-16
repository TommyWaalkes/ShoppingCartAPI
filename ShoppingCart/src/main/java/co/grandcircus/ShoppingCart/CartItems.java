package co.grandcircus.ShoppingCart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartItems {
	@Id
	private long id;
	private String product; 
	private double price; 
	private int quantity;
	
	public long getId() {
		return id; 
	}
	
	public void setId(long id) {
		this.id = id; 
	}
	
	public String getProduct() {
		return this.product;
	}
	
	public void setProdcut(String product) {
		this.product = product;
	}
	
	public double getPrice() {
		return price; 
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	 
}
