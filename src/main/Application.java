package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.github.javafaker.Faker;

import domain.Cart;
import domain.Category;
import domain.Currency;
import domain.CurrencyProvider;
import domain.DataRepository;
import domain.Money;
import domain.Product;
import domain.ProductFactory;
import domain.ProductRepository;

public class Application {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		CurrencyProvider currencyProvider = new CurrencyProvider().getInstance();
		ProductFactory productFactory = new ProductFactory();
		DataRepository dataRepository = new DataRepository();
		
		Product p = productFactory.getFakeProduct();
		System.out.println("Created product:\n" + p);
	
		dataRepository.save(p);	
		p = dataRepository.load(Product.class);
		System.out.println("Product from file:\n" +p +"\n");
		
		Money money = new Money();
		System.out.println("Created money:\n" + money);
		dataRepository.save(money);
		
		money = dataRepository.load(Money.class);
		System.out.println("Money from file:\n" + money);
		/*
		 
		 Cart cart = new Cart().getInstance();
		 
		//CurrencyProvider currencyProvider = new CurrencyProvider().getInstance();
		
		Faker faker = new Faker();
		Calendar futureDate = Calendar.getInstance();
		futureDate.add(Calendar.DATE, 15);
		
		cart.add(productFactory.getProduct(
								"Hat", 
								new Money(CurrencyProvider.getInstance().generateFakeCurrencyCode(), (float)300), 
								1, 
								faker.date().between(
										Calendar.getInstance().getTime(), 
										futureDate.getTime()), 
								"md", 
								new Category("Beauty"))
				);
				
		cart.add(productFactory.getProduct(
								"Yuliia", 
								new Money(CurrencyProvider.getInstance().generateFakeCurrencyCode(), (float)300), 
								2, 
								faker.date().between(
										Calendar.getInstance().getTime(), 
										futureDate.getTime()), 
								"md", 
								new Category("Beauty"))
				);
		cart.findAll().forEach(c -> System.out.println(c));
		
		cart.calculateTotal("USD");		
		System.out.println("---Total of all products from your cart : " + cart.getTotal().getAmount() + "---");
		
		
		cart.add(productFactory.getFakeProduct());
		
		List<Product> p = new ArrayList<>(); 
		p = productFactory.getManyFakeProducts(2);
		
		p.forEach(pr -> cart.add(pr));
		
		cart.add(productFactory.getProduct(
					"Hat", 
					new Money("USD", (float)300), 
					2, 
					faker.date().between(
							Calendar.getInstance().getTime(), 
							futureDate.getTime()), 
					"md", 
					new Category("1")));
		
		System.out.println("---Cart find all---");
		
		cart.findAll().forEach(c -> System.out.println(c));
				
		/*System.out.println("---Cart find by Name---");
		cart.findByName("Hat").forEach(c -> System.out.println(c));;
		
		System.out.println("---Cart find by Manufacturer = md ---");
		cart.findByManufacturer("md").forEach(c-> System.out.println(c));;
		
		System.out.println("---Cart find by category  ---");
		cart.findByCategory("Beauty").forEach(c-> System.out.println(c));;
		
		System.out.println("---Deleting product with id=3---");
		cart.delete(3);
		cart.findAll().forEach(c -> System.out.println(c));
		
		System.out.println("---Updating product with id=1 , quantity to 1---");
		cart.updateQuantity(1, 1);
		System.out.println(cart.findById(1));
		
		Date date = faker.date().between(
				Calendar.getInstance().getTime(), 
				futureDate.getTime());
		
		System.out.println("---Products with Expiration date from " + date +" ---");
		cart.findByExpirationDateFrom(date).forEach(c -> System.out.println(c));
		
		System.out.println("---Products with Expiration date to " + date +" ---");
		cart.findByExpirationDateTo(date).forEach(c -> System.out.println(c)); ;
		
		Date fromDate = faker.date().between(
				Calendar.getInstance().getTime(), 
				futureDate.getTime());
		Date toDate = faker.date().between(
				Calendar.getInstance().getTime(), 
				futureDate.getTime());
		System.out.println( fromDate +"   "+ toDate);
		
		if(toDate.after(fromDate)){
			System.out.println("---Products with Expiration date from " + fromDate +" to "+ toDate + " ---");
			cart.findByExpirationDateBetween(fromDate,toDate).forEach(c -> System.out.println(c));;
		}else{
			System.out.println("---Products with Expiration date from " + toDate +" to "+ fromDate + " ---");
			cart.findByExpirationDateBetween(toDate,fromDate).forEach(c -> System.out.println(c));;			
		}
		*/

	}


}
