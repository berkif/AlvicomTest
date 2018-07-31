package service;

import java.util.List;
import java.util.Scanner;

import dao.BankAccountDao;
import dao.ReportDao;
import dto.Transaction;
import service.parser.ConsoleParser;
import service.parser.Parser;

public class App {

	private static final int generateReportsBy = 10;

	public static void main(String[] args) {
		BankAccountDao.addExampleAccounts();
		welcomeUser();
		List<Transaction> transactions = getTransactions();

		while (transactions.size() > generateReportsBy) {
			List<Transaction> subList = transactions.subList(0, generateReportsBy - 1);
			generateReports(transactions, subList);
		}
		generateReports(transactions, transactions);

		System.out.println("THE END");
	}

	private static void generateReports(List<Transaction> allTransactions, List<Transaction> subList) {
		subList.forEach(tr -> AccountsService.processTransaction(tr));
		ReportService.generateReports(subList);
		ReportService.printReports();
		allTransactions.removeAll(subList);
		ReportDao.clearReports();
	}

	private static List<Transaction> getTransactions() {
		Scanner scanner = new Scanner(System.in);
		String fileLocation = scanner.nextLine().trim();
		Parser parser = new ConsoleParser(";");
		List<Transaction> transactions = parser.getTransactions(fileLocation);
		scanner.close();
		return transactions;
	}

	private static void welcomeUser() {
		System.out.println(
				"Welcome! This application reads transactions from a CSV file, please use the following format in your file:");
		System.out.println("11111111-22222222;HUF;-30000;257.21");
		System.out.println("I will generate reports by 10 transactions!");
		System.out.println("Please type the CSV file location!");
	}

}
