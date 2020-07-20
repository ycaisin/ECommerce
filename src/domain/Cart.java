package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// cart commerce (Business logic )+ ProdReposit
public class Cart implements ProductRepository{
	
	private static List<Product> products = new ArrayList<>();

	private static Money total = new Money("md lei", (float)0);
	
	
	@Override
	public void add(Product product) {
		if(product!=null)
			products.add(product);
		
	}

	@Override
	public void delete(Integer productId) {
		Product product = findById(productId);
		products.remove(product);
		
	}

	@Override
	public void updateQuantity(Integer productId, Integer newQty) {
		Product product = findById(productId);
		product.setQuantity(newQty);
		
	}

	@Override
	public Product findById(Integer productId) {
		for (Product p : products) {
			if(p.getId().equals(productId)){
				return p;
			}
		}
		
		return null;
	}

	@Override
	public List<Product> findAll() {
		return products;
	}

	@Override
	public List<Product> findByName(String productName) {
		List<Product> foundProducts = new ArrayList<>();
		products.forEach(p -> {if(p.getName().equals(productName))
				foundProducts.add(p);});
		
		return foundProducts;
	}

	@Override
	public List<Product> findByManufacturer(String productManufacturer) {
		List<Product> foundProducts = new ArrayList<>();
		for (Product p : products) {
			if(p.getMannufactured().equals(productManufacturer))
				foundProducts.add(p);
		}
		return foundProducts;
	}

	@Override
	public List<Product> findByCategory(String productCategory) {
		List<Product> foundProducts = new ArrayList<>();
		for (Product p : products) {
			if(p.getCategory().getName().equals(productCategory))
				foundProducts.add(p);
		}
		return foundProducts;
	}

	@Override
	public List<Product> findByExpirationDateFrom(Date fromDate) {
		List<Product> foundProducts = new ArrayList<>();
		for (Product p : products) {
			if(p.getExpiration().after(fromDate))
				foundProducts.add(p);
		}
		return foundProducts;
		
		
	}

	@Override
	public List<Product> findByExpirationDateTo(Date toDate) {
		List<Product> foundProducts = new ArrayList<>();
		for (Product p : products) {
			if(p.getExpiration().before(toDate))
				foundProducts.add(p);
		}
		return foundProducts;	
	}

	@Override
	public List<Product> findByExpirationDateBetween(Date fromDate, Date toDate) {
		List<Product> foundProducts = new ArrayList<>();
		for (Product p : products) {
			if(p.getExpiration().before(toDate)&&p.getExpiration().after(fromDate))
				foundProducts.add(p);
		}
		return foundProducts;	
	}

	
	///////// 
	
	public Money getTotal(){
		return total;
	}; 
	
	public void calculateTotal(){
		Float sum = (float) 0;
		Float exchangedValue = (float) 0;
		for (Product p : products) {
			exchangedValue = currencyExchange(p);
			sum = sum + exchangedValue*p.getQuantity();
		}
		total.setAmount(sum); 
	};
	
	public Float currencyExchange(Product p){
		switch(p.getPrice().getCurrency()){
			case "EUR": return (float) (p.getPrice().getAmount() * 19.51);
			case "USD": return (float) (p.getPrice().getAmount() * 17.07);
			case "UAH": return (float) (p.getPrice().getAmount() * 0.62);
			case "RON": return (float) (p.getPrice().getAmount() * 4.03);
			case "PLN": return (float) (p.getPrice().getAmount() * 4.35);
			case "CZK": return (float) (p.getPrice().getAmount() * 0.73);
			case "GBP": return (float) (p.getPrice().getAmount() * 21.43);
			case "AUD": return (float) (p.getPrice().getAmount() * 11.93);
			case "BYN": return (float) (p.getPrice().getAmount() * 7.12);
		}
		return (float) (p.getPrice().getAmount() * 0.1);
	}

}
