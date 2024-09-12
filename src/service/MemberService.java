package service;

import model.Member;

public interface MemberService {
		// crate
		void addMB(String username, String password);
		
		// read
		Member queryByUN(String username);
		
}
