package service;

import java.util.List;

import dao.BankAccountDao;
import dao.ReportDao;
import dto.Report;
import dto.Transaction;

public class ReportService {

	public static void generateReports(List<Transaction> transactions) {
		for (Transaction transaction : transactions) {
			String accountNumber = transaction.getAccountNumber();
			if (BankAccountDao.isBankAccountPresented(accountNumber)) {
				if (ReportDao.isBankAccountPresented(accountNumber)) {
					ReportDao.getReport(accountNumber).get().addTransaction(transaction);
				} else {
					Report newReport = new Report(BankAccountDao.getBankAccount(accountNumber).get());
					newReport.addTransaction(transaction);
					ReportDao.addReport(newReport);
				}
			}
		}
	}

	public static void printReports() {
		ReportDao.getReports().forEach((k, v) -> System.out.println(v.toString()));
	}

}