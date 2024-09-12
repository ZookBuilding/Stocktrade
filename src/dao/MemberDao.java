package dao;

import model.Member;

public interface MemberDao {
	//create
	void addMember(String username,String password);
	
	//read
	Member queryUsername(String username);
	
	//update
	//void updateMember(Member data);
	
	//dalete
	//void daleMember(String username);
	
	
	
	

}
