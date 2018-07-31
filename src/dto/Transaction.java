package dto;

import java.math.BigDecimal;

public class Transaction {

	private final String accountNumber;
	private final String currency;
	private final BigDecimal amount;
	private final BigDecimal exchangeRate;

	public Transaction(String accountNumber, String currency, BigDecimal amount, BigDecimal exchangeRate) {
		this.accountNumber = accountNumber;
		this.currency = currency;
		this.amount = amount;
		this.exchangeRate = exchangeRate;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

}
