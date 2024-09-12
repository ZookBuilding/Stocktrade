package dao;

import java.util.List;

import model.Optional;

public interface OptionalDao {
	//create
	void addOptional(Optional date);
	//read
	List<Optional> queryOptional(String username);
	//update
	void updateOptional(String stockid);
	//dalete
	void daleteOPtional(String username,String stockid);

}
