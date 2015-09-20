package ninja.pif.simpleshop.model;


public class Article {
	
	private String title = "";
	private String descrption = "";
	private double price = 0d;
	
	public String getTitle() {
	
		return title;
	}
	
	public void setTitle(String title) {
	
		this.title = title;
	}
	
	public String getDescrption() {
	
		return descrption;
	}
	
	public void setDescrption(String descrption) {
	
		this.descrption = descrption;
	}
	
	public double getPrice() {
	
		return price;
	}
	
	public void setPrice(double price) {
	
		this.price = price;
	}

	@Override
	public String toString() {

		return "Article [title=" + title + ", descrption=" + descrption + ", price=" + price + "]";
	}
	
	
}
