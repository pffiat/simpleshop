package ninja.pif.simpleshop.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;


public class Bill {
	
	private int shippingPrice = 7;

	List<ArticleBill> arcticleBills;
	
	private String commandeId = "0";
	
	AddressBill facurationAddress = new AddressBill();
	AddressBill receptionAddress = new AddressBill();
	

	public Document toDocument() {
		return new Document()
		.append("facurationAddress", facurationAddress.toDocument())
		.append("receptionAddress", receptionAddress.toDocument())
		.append("arcticleBills", getShippedArcticleBillsDocument())
		.append("shippingPrice", shippingPrice);
	}
	
	private String token;
	
	public Bill() {
		arcticleBills = new ArrayList<ArticleBill>();
		
		ArticleBill articleBill = new ArticleBill();
		articleBill.setName("Pyschiâtre de quartier");
		articleBill.setPrice(12);
		arcticleBills.add(articleBill);
		
		ArticleBill articleBill2 = new ArticleBill();
		articleBill2.setName("Suis-je normal, Docteur?");
		articleBill2.setPrice(12);
		arcticleBills.add(articleBill2);
		
		ArticleBill articleBill3 = new ArticleBill();
		articleBill3.setName("Théâtrothérapie");
		articleBill3.setPrice(12);
		arcticleBills.add(articleBill3);
		
		ArticleBill articleBill4 = new ArticleBill();
		articleBill4.setName("La Psychanalyse au risque du voyage");
		articleBill4.setPrice(12);
		arcticleBills.add(articleBill4);
		
		token = "eyJ2ZXJzaW9uIjoyLCJhdXRob3JpemF0aW9uRmluZ2VycHJpbnQiOiI5MDUwMDA1YjQyOWJhMTJjMThkZjI2NTdiM2IyNTYwYzgyZTM2MDZkNjExYWJlYzE1ZTMzNTc1MTIwM2VmZTdmfGNyZWF0ZWRfYXQ9MjAxNS0wOC0wM1QxMjowOToxNy42NjIyNDU3MDQrMDAwMFx1MDAyNm1lcmNoYW50X2lkPWRjcHNweTJicndkanIzcW5cdTAwMjZwdWJsaWNfa2V5PTl3d3J6cWszdnIzdDRuYzgiLCJjb25maWdVcmwiOiJodHRwczovL2FwaS5zYW5kYm94LmJyYWludHJlZWdhdGV3YXkuY29tOjQ0My9tZXJjaGFudHMvZGNwc3B5MmJyd2RqcjNxbi9jbGllbnRfYXBpL3YxL2NvbmZpZ3VyYXRpb24iLCJjaGFsbGVuZ2VzIjpbXSwiZW52aXJvbm1lbnQiOiJzYW5kYm94IiwiY2xpZW50QXBpVXJsIjoiaHR0cHM6Ly9hcGkuc2FuZGJveC5icmFpbnRyZWVnYXRld2F5LmNvbTo0NDMvbWVyY2hhbnRzL2RjcHNweTJicndkanIzcW4vY2xpZW50X2FwaSIsImFzc2V0c1VybCI6Imh0dHBzOi8vYXNzZXRzLmJyYWludHJlZWdhdGV3YXkuY29tIiwiYXV0aFVybCI6Imh0dHBzOi8vYXV0aC52ZW5tby5zYW5kYm94LmJyYWludHJlZWdhdGV3YXkuY29tIiwiYW5hbHl0aWNzIjp7InVybCI6Imh0dHBzOi8vY2xpZW50LWFuYWx5dGljcy5zYW5kYm94LmJyYWludHJlZWdhdGV3YXkuY29tIn0sInRocmVlRFNlY3VyZUVuYWJsZWQiOnRydWUsInRocmVlRFNlY3VyZSI6eyJsb29rdXBVcmwiOiJodHRwczovL2FwaS5zYW5kYm94LmJyYWludHJlZWdhdGV3YXkuY29tOjQ0My9tZXJjaGFudHMvZGNwc3B5MmJyd2RqcjNxbi90aHJlZV9kX3NlY3VyZS9sb29rdXAifSwicGF5cGFsRW5hYmxlZCI6dHJ1ZSwicGF5cGFsIjp7ImRpc3BsYXlOYW1lIjoiQWNtZSBXaWRnZXRzLCBMdGQuIChTYW5kYm94KSIsImNsaWVudElkIjpudWxsLCJwcml2YWN5VXJsIjoiaHR0cDovL2V4YW1wbGUuY29tL3BwIiwidXNlckFncmVlbWVudFVybCI6Imh0dHA6Ly9leGFtcGxlLmNvbS90b3MiLCJiYXNlVXJsIjoiaHR0cHM6Ly9hc3NldHMuYnJhaW50cmVlZ2F0ZXdheS5jb20iLCJhc3NldHNVcmwiOiJodHRwczovL2NoZWNrb3V0LnBheXBhbC5jb20iLCJkaXJlY3RCYXNlVXJsIjpudWxsLCJhbGxvd0h0dHAiOnRydWUsImVudmlyb25tZW50Tm9OZXR3b3JrIjp0cnVlLCJlbnZpcm9ubWVudCI6Im9mZmxpbmUiLCJ1bnZldHRlZE1lcmNoYW50IjpmYWxzZSwiYnJhaW50cmVlQ2xpZW50SWQiOiJtYXN0ZXJjbGllbnQzIiwibWVyY2hhbnRBY2NvdW50SWQiOiJzdGNoMm5mZGZ3c3p5dHc1IiwiY3VycmVuY3lJc29Db2RlIjoiVVNEIn0sImNvaW5iYXNlRW5hYmxlZCI6dHJ1ZSwiY29pbmJhc2UiOnsiY2xpZW50SWQiOiIxMWQyNzIyOWJhNThiNTZkN2UzYzAxYTA1MjdmNGQ1YjQ0NmQ0ZjY4NDgxN2NiNjIzZDI1NWI1NzNhZGRjNTliIiwibWVyY2hhbnRBY2NvdW50IjoiY29pbmJhc2UtZGV2ZWxvcG1lbnQtbWVyY2hhbnRAZ2V0YnJhaW50cmVlLmNvbSIsInNjb3BlcyI6ImF1dGhvcml6YXRpb25zOmJyYWludHJlZSB1c2VyIiwicmVkaXJlY3RVcmwiOiJodHRwczovL2Fzc2V0cy5icmFpbnRyZWVnYXRld2F5LmNvbS9jb2luYmFzZS9vYXV0aC9yZWRpcmVjdC1sYW5kaW5nLmh0bWwiLCJlbnZpcm9ubWVudCI6Im1vY2sifSwibWVyY2hhbnRJZCI6ImRjcHNweTJicndkanIzcW4iLCJ2ZW5tbyI6Im9mZmxpbmUiLCJhcHBsZVBheSI6eyJzdGF0dXMiOiJtb2NrIiwiY291bnRyeUNvZGUiOiJVUyIsImN1cnJlbmN5Q29kZSI6IlVTRCIsIm1lcmNoYW50SWRlbnRpZmllciI6Im1lcmNoYW50LmNvbS5icmFpbnRyZWVwYXltZW50cy5zYW5kYm94LkJyYWludHJlZS1EZW1vIiwic3VwcG9ydGVkTmV0d29ya3MiOlsidmlzYSIsIm1hc3RlcmNhcmQiLCJhbWV4Il19fQ";
//						new BraintreeGateway(
//			  Environment.SANDBOX,
//			  BraintreeConstants.MERCHAND_ID,
//			  BraintreeConstants.PUBLIC_KEY,
//			  BraintreeConstants.PRIVATE_KEY
//			).clientToken().generate();
		
	}
	
	
	public String getCommandeId() {
	
		return commandeId;
	}

	
	public void setCommandeId(String commandeId) {
	
		this.commandeId = commandeId;
	}

	public String getToken() {
	
		return token;
	}
	
	public void setToken(String token) {
	
		this.token = token;
	}




	public int getShippingPrice() {
	
		return shippingPrice;
	}



	
	public void setShippingPrice(int shippingPrice) {
	
		this.shippingPrice = shippingPrice;
	}



	public List<ArticleBill> getShippedArcticleBills() {

		List<ArticleBill> shippedArcticleBills = new ArrayList<ArticleBill>();
		for (ArticleBill articleBill : arcticleBills) {
			if(articleBill.getQuantity() != 0) {
				shippedArcticleBills.add(articleBill);
			}
		}
		
		return shippedArcticleBills;
	}
	
	private List<Document> getShippedArcticleBillsDocument() {
		List<Document> documents = new ArrayList<Document>();
		List<ArticleBill> articleBills = getShippedArcticleBills();
		for (ArticleBill articleBill : articleBills) {
			documents.add(articleBill.toDocument());
		}
		return documents;
	}

	public List<ArticleBill> getArcticleBills() {
	
		return arcticleBills;
	}
	
	public void setArcticleBills(List<ArticleBill> arcticleBills) {
	
		this.arcticleBills = arcticleBills;
	}
	
	public AddressBill getFacurationAddress() {
	
		return facurationAddress;
	}
	
	public void setFacurationAddress(AddressBill facurationAddress) {
	
		this.facurationAddress = facurationAddress;
	}
	
	public AddressBill getReceptionAddress() {
	
		return receptionAddress;
	}
	
	public void setReceptionAddress(AddressBill receptionAddress) {
	
		this.receptionAddress = receptionAddress;
	}
	
	public double getTTCPrice() {
		double price = 0d;
		for (ArticleBill articleBill : arcticleBills) {
			price += articleBill.getPrice() * articleBill.getQuantity();
		}
		return round(price,2);
	}
	
	public double getHTPrice() {
		double price = 0d;
		for (ArticleBill articleBill : arcticleBills) {
			price += articleBill.getPrice() * articleBill.getQuantity();
		}
		return round(price * 0.8d ,2);
	}
	
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	@Override
	public String toString() {

		return "Bill [shippingPrice=" + shippingPrice + ", arcticleBills=" + arcticleBills + ", facurationAddress=" +
			facurationAddress + ", receptionAddress=" + receptionAddress + "]";
	}
	
	
}
