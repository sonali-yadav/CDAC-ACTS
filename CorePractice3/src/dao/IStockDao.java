package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.Stock;

public interface IStockDao {

	// 1. Delete stock record from DB
	String deleteStockRecord(String companyName) throws SQLException;

	// 2. Add new stock
	String addNewStock(Stock s) throws SQLException;

	// 3. Update stock values
	String updateStockValues(String cName, double price, int quantity) throws SQLException;
	
	//THIS IS EXTRA, ADDED FOR DATA VIEWING/TESTING PURPOSE
	List<Stock> getAllStocks() throws SQLException;
}
