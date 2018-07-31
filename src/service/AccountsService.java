package service;

import java.math.BigDecimal;
import java.util.Optional;

import dao.BankAccountDao;
import dto.BankAccount;
import dto.Transaction;

public class AccountsService {

	public static void processTransaction(Transaction transaction) {
		Optional<BankAccount> optionalAccount = BankAccountDao.getBankAccount(transaction.getAccountNumber());
		if (optionalAccount.isPresent()) {
			BankAccount account = optionalAccount.get();
			if (transaction.getExchangeRate() == null) {
				account.modifyBalance(transaction.getAmount());
			} else {
				BigDecimal amount = transaction.getAmount().multiply(transaction.getExchangeRate());
				account.modifyBalance(amount);
			}
		} else {
			System.out.println(
					"WARNING: The following account number is not in our database: " + transaction.getAccountNumber());
		}
	}

}
