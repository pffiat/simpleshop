package ninja.pif.simpleshop.model;

import org.bson.Document;


public class ArticleBill {
	
	private String name = "";
	private int quantity = 0;
	private double price = 0;
	


	public Document toDocument() {
		return new Document()
		.append("name", name)
		.append("quantity", quantity)
		.append("price", price);
	}
	
	@Override
	public String toString() {

		return "ArticleBill [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	public String getName() {
	
		return name;
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	public int getQuantity() {
	
		return quantity;
	}
	
	public void setQuantity(int quantity) {
	
		this.quantity = quantity;
	}
	
	public double getPrice() {
	
		return price;
	}
	
	public void setPrice(double price) {
	
		this.price = price;
	}
}
