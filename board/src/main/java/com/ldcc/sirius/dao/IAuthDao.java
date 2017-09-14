package com.ldcc.sirius.dao;

import com.ldcc.sirius.vo.Auth;

public interface IAuthDao {

	public boolean register(Auth auth);
	
	public String checkAuth(String id);
	
	public int checkExistId(String id);
	
	public Auth getOne(String id);
}
