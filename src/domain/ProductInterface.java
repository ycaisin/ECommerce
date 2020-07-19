package domain;

import java.util.Date;
import java.util.List;

public interface ProductInterface {
	
	public ProductInterface createProduct(String name, Money price, Integer quantity, Date expiration, String mannufactured,
			Category category);
	
	public Product createFakeProduct();
	
	public List<Product> createManyFakeProducts(int qty);
}
