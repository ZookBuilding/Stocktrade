package service.impl;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberDaoImpl mdi = new MemberDaoImpl();
	@Override
	public void addMB(String username, String password) {
		mdi.addMember( username, password);
		
	}

	@Override
	public Member queryByUN(String username) {
		Member mb = mdi.queryUsername(username);
		
		return mb;
	}

}
