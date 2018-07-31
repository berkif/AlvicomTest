package service.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dto.Transaction;

public class ConsoleParser implements Parser {

	private String cvsSplitBy;

	public ConsoleParser(String cvsSplitBy) {
		this.cvsSplitBy = cvsSplitBy;
	}

	@Override
	public List<Transaction> getTransactions(String filePlace) {
		String line = "";
		List<Transaction> transactions = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePlace))) {
			while ((line = br.readLine()) != null) {
				String[] data = line.split(cvsSplitBy);
				transactions.add(new Transaction(data[0], data[1], getNumericData(data[2]), getNumericData(data[3])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return transactions;
	}

	private BigDecimal getNumericData(String data) {
		BigDecimal result = null;
		if (!data.equals("null")) {
			result = new BigDecimal(data);
		}
		return result;
	}

}
