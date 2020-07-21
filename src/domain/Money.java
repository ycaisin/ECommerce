package domain;

public class Money {
	private Currency currency;
	private Float 	amount;
	
	private CurrencyProvider currencyProvider = new CurrencyProvider();
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	public Money() {
	}
	
	public Money(String currencyCode, Float amount) {
		this.currency = CurrencyProvider.getInstance().getCurrency(currencyCode); 
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Money [currency=" + currency.toString() + ", amount=" + amount + "]";
	}
	
	 public Currency toCurrency(String code){
		Currency c = currencyProvider.getCurrency(code);
		Currency newCurrency = new Currency(code, currency.getRate()*amount/c.getRate());
	 	return newCurrency;
	 }
}
