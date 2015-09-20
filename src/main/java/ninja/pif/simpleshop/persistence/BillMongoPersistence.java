package ninja.pif.simpleshop.persistence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class BillMongoPersistence {

	public void insertBill(Document document) {
		
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("simpleshop");
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.FRANCE);
		
		db.getCollection("bills").insertOne(document);
		
	}
}
