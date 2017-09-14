package com.ldcc.sirius.service;

import javax.servlet.http.HttpSession;

import com.ldcc.sirius.vo.Auth;

public interface AuthService {

	public boolean loginRequest(String id, String pw);
	
	public void logoutRequest(HttpSession session);
	
	public boolean joinRequest(Auth vo);

	public boolean checkExistId(String id);
	
	public Auth getOne(String id);
}
