package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import dto.Report;

public class ReportDao {

	private static Map<String, Report> reports = new HashMap<>();

	public static Optional<Report> getReport(String accountNumber) {
		Report result = reports.get(accountNumber);
		return Optional.ofNullable(result);
	}

	public static boolean isBankAccountPresented(String accountNumber) {
		Report result = reports.get(accountNumber);
		return result != null;
	}

	public static void addReport(Report report) {
		reports.put(report.getAccountNumber(), report);
	}

	public static void clearReports() {
		reports.clear();
	}

	public static Map<String, Report> getReports() {
		return reports;
	}

}
