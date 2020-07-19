package domain;

import java.util.Date;
import java.util.List;

public class ProductFactory {

	//modify product;
	//create product interface
	//create products from here
	
	
	// getProduct(  parameters... ) return new product
	// getfakeProduct () ret fake product
	// getManyFakeProducts(qty) return list of fake prod. (main)
	
	public Product getProduct(String name, Money price, Integer quantity, Date expiration, String mannufactured,
			Category category){
		return new Product().createProduct(name, price, quantity, expiration, mannufactured, category);
		
	} 
	
	public Product getFakeProduct(){
		return new Product().createFakeProduct();
		
	} 
	
	public List<Product> getManyFakeProducts(int qty){
		return new Product().createManyFakeProducts(qty);
	}
	
}
