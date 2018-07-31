package dto;

import java.util.ArrayList;
import java.util.List;

public class Report {

	private final BankAccount account;
	private List<Transaction> transactions = new ArrayList<>();

	public Report(BankAccount account) {
		this.account = account;
	}

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public String getAccountNumber() {
		return account.getAccountNumber();
	}

	@Override
	public String toString() {
		String lineSeparator = System.getProperty("line.separator");

		StringBuilder sb = new StringBuilder();
		sb.append("Report for account: ").append(account.getAccountNumber()).append(lineSeparator);
		sb.append("There were ").append(transactions.size()).append(" transactions:").append(lineSeparator);
		transactions.forEach(tr -> sb.append(tr.getAmount()).append(" in the following currency: ")
				.append(tr.getCurrency() == null ? account.getCurrency() : tr.getCurrency()).append(lineSeparator));
		sb.append("The balance for the account: ").append(account.getBalance().toString()).append(lineSeparator);

		return sb.toString();
	}

}
