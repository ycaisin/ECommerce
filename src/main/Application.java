package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import domain.Category;
import domain.Money;
import domain.Product;
import domain.ProductFactory;

public class Application {

	public static void main(String[] args) {
		ProductFactory productFactory = new ProductFactory();
		
		//-----test 1 product-------
		System.out.println("---Test 1 product creating---");
		System.out.println(productFactory.getProduct(
								"Hat", 
								new Money("test currency", (float)300), 
								2, 
								null, 
								"md", 
								new Category("Beauty"))
		);
		
		//-----test 1 fake product-------
		System.out.println("---Test 1 fake product creating---");
		System.out.println(productFactory.getFakeProduct());
		
		
		System.out.println("---Test many products creating---");
		//-----test many products-------
		List<Product> p = new ArrayList<>(); 
		p = productFactory.getManyFakeProducts(3);
		
		p.forEach(pr -> System.out.println(pr));
		
	}

	

}
