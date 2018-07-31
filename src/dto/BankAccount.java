package dto;

import java.math.BigDecimal;

public class BankAccount {

	private final String accountNumber;
	private String currency;
	private BigDecimal balance;

	public BankAccount(String accountNumber, String currency, BigDecimal balance) {
		this.accountNumber = accountNumber;
		this.currency = currency;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void modifyBalance(BigDecimal value) {
		balance = balance.add(value);
	}

}
