package dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import dto.BankAccount;

public class BankAccountDao {

	private static Map<String, BankAccount> accounts = new HashMap<>();

	public static void addExampleAccounts() {
		accounts.put("11111111-22222222", new BankAccount("11111111-22222222", "HUF", BigDecimal.valueOf(150000)));
		accounts.put("22222222-33333333", new BankAccount("22222222-33333333", "USD", BigDecimal.valueOf(1230)));
	}

	public static Optional<BankAccount> getBankAccount(String accountNumber) {
		BankAccount result = accounts.get(accountNumber);
		return Optional.ofNullable(result);
	}

	public static boolean isBankAccountPresented(String accountNumber) {
		BankAccount result = accounts.get(accountNumber);
		return result != null;
	}

}
