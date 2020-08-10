package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.crypto.Data;

import com.github.javafaker.Faker;

public class Product implements ProductInterface, Serializable{
	
	private Integer id; 
	private String name;
	private Money price;
	private Integer quantity;
	private Date 	expiration;
	private String 	manufacturer;
	private Category category;
	
	private Product(Integer id,String name, Money price, Integer quantity, Date expiration, String mannufactured,
			Category category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.expiration = expiration;
		this.manufacturer = mannufactured;
		this.category = category;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getId() {
		return id;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Money getPrice() {
		return price;
	}
	public void setPrice(Money price) {
		this.price = price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	public String getMannufactured() {
		return manufacturer;
	}
	public void setMannufactured(String mannufactured) {
		this.manufacturer = mannufactured;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id =  " +id +" name = " + name + ", price = " + price.getCurrency() + ":" + price.getAmount() + ", quantity = " + quantity + ", expiration = " + expiration
				+ ", mannufactured = " + manufacturer + ", category = " + category.getName() + "]";
	}

	@Override
	public Product createProduct(Integer id, String name, Money price, Integer quantity, Date expiration, String mannufactured,
			Category category) {
		return new Product(id, name, price, quantity, expiration, mannufactured, category);
	}

	@Override
	public Product createFakeProduct(Integer id) {
		Faker faker = new Faker();
		
		Calendar futureDate = Calendar.getInstance();
		futureDate.add(Calendar.DATE, 15);
		return new Product(id, faker.commerce().productName(), 
						new Money(CurrencyProvider.getInstance().generateFakeCurrencyCode(), 
						(Float)faker.random().nextInt(0, 2000).floatValue()),
						faker.random().nextInt(0, 50), faker.date().between(Calendar.getInstance().getTime(), futureDate.getTime()) ,
						faker.country().countryCode2(), 
						new Category(faker.commerce().department())  );
		
	}

	@Override
	public List<Product> createManyFakeProducts (int qty, Integer id){
		Faker faker = new Faker();
		List<Product> products = new ArrayList<>();
		
		while(products.size()<qty){
			Calendar futureDate = Calendar.getInstance();
			futureDate.add(Calendar.DATE, 15);
			
			products.add( 
					new Product(++id,faker.commerce().productName(), 
								new Money(CurrencyProvider.getInstance().generateFakeCurrencyCode(), 
								(Float)faker.random().nextInt(0, 2000).floatValue()),
								faker.random().nextInt(0, 50), 
								faker.date().between(Calendar.getInstance().getTime(), futureDate.getTime()) , 
								faker.country().countryCode2(), 
								new Category(faker.commerce().department())  )
					);
		}
		
		return products;
	}
	
	

}
