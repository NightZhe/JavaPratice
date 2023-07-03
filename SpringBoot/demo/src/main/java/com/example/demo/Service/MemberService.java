package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.MemberDao;
import com.example.demo.Model.MemberAccount;


@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	// StudentDao studentDao;
	public void addMember(MemberAccount memberAccount){
		memberDao.addMember(memberAccount);
	}
}
