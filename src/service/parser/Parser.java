package service.parser;

import java.util.List;

import dto.Transaction;

public interface Parser {

	public List<Transaction> getTransactions(String filePlace);

}
