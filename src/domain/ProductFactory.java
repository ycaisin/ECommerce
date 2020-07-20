package domain;

import java.util.Date;
import java.util.List;

public class ProductFactory {
	private static Integer productCount = 0; // 1. change factory to singleTone
		
	public Product getProduct(String name, Money price, Integer quantity, Date expiration, String mannufactured,
			Category category){
		return new Product().createProduct(
				++productCount, name, price, quantity, expiration, mannufactured, category);
	} 
	
	public Product getFakeProduct(){
		return new Product().createFakeProduct(++productCount);
	} 
	
	public List<Product> getManyFakeProducts(int qty){
		Integer startId = productCount;
		productCount = productCount + qty;
		return new Product().createManyFakeProducts(qty, startId );
	}
	
}
