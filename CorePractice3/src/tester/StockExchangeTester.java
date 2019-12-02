package tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.StockDaoImpl;
import pojo.Stock;

public class StockExchangeTester {

	public static void main(String[] args) {
		int choice = 0;
		try (Scanner sc = new Scanner(System.in);) {
			StockDaoImpl sdao = new StockDaoImpl();
			do {
				System.out.println("***MENU***");
				System.out.println("1. Delete stock record from DB" + "\n" + "2. Add new stock" + "\n"
						+ "3. Update stock values" + "\n" + "4. View Current Stock" + "\n" + "0. Exit");
				System.out.println("Enter your choice:");

				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter Company Name: ");
					String cName = sc.next();
					System.out.println(sdao.deleteStockRecord(cName));
					break;
				case 2:
					System.out.println("Enter Details: quantity, name, company, price, closingDate[yyyy-MM-dd]");
					Stock stock = new Stock(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),
							Date.valueOf(sc.next()));
					System.out.println(sdao.addNewStock(stock));
					break;
				case 3:
					System.out.println("Enter Company Name to update, new price, new quantity");
					System.out.println(sdao.updateStockValues(sc.next(), sc.nextDouble(), sc.nextInt()));
					break;
				case 4:
					List<Stock> stockList = sdao.getAllStocks();
					for (Stock stock2 : stockList) {
						System.out.println(stock2);
					}
					break;
				case 0:
					System.out.println("Thank you for using the application!");
					break;
				default:
					break;
				}
			} while (choice != 0);
		} catch (SQLException ex) {
			System.out.println(ex);
		} catch (ClassNotFoundException ex1) {
			System.out.println(ex1);
		}
	}
}