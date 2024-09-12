package dao;

import java.util.List;

import model.Transaction;

public interface TransactionDao {
	//create
	void addTransaction(Transaction data);
	//read 
	List<Transaction> queryByUsername(String username);
} 
