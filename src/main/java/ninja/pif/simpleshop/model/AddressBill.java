package ninja.pif.simpleshop.model;

import org.bson.Document;


public class AddressBill {

	private String name = "";
	private String email = "";
	private String street = "";
	private String postalCode = "";
	private String city = "";
	private String complement = "";


	public Document toDocument() {
		return new Document()
		.append("name", name)
		.append("email", email)
		.append("complement", complement)
		.append("street", street)
		.append("postalCode", postalCode)
		.append("city", city);
	}
	
	public String getEmail() {
	
		return email;
	}

	
	public void setEmail(String email) {
	
		this.email = email;
	}

	public String getName() {	
		return name;
	}
	
	public void setName(String name) {	
		this.name = name;
	}
	
	public String getStreet() {	
		return street;
	}
	
	public void setStreet(String street) {	
		this.street = street;
	}
	
	public String getPostalCode() {	
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {	
		this.postalCode = postalCode;
	}
	
	public String getCity() {	
		return city;
	}
	
	public void setCity(String city) {	
		this.city = city;
	}
	
	public String getComplement() {	
		return complement;
	}
	
	public void setComplement(String complement) {	
		this.complement = complement;
	}


	@Override
	public String toString() {

		return "AddressBill [name=" + name + ", email=" + email + ", street=" + street + ", postalCode=" + postalCode +
			", city=" + city + ", complement=" + complement + "]";
	}
	
	

}
