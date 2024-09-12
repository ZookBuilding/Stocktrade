package service;

import java.util.List;

import model.Transaction;

public interface TransactionService {
	// create
		void addSK(Transaction data);
		
		
		// read
		List<Transaction> queryByUN(String username);
	
}
