package com.ldcc.sirius.service;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldcc.sirius.dao.IAuthDao;
import com.ldcc.sirius.vo.Auth;

@Service("authService")
public class AuthServiceImpl implements AuthService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean loginRequest(String id, String pw) {
		// TODO Auto-generated method stub
		IAuthDao authDao = sqlSession.getMapper(IAuthDao.class);
		String checkPw = authDao.checkAuth(id);
		return checkPw != null && checkPw.equals(pw);
	}	
	
	@Override
	public void logoutRequest(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate();
	}

	@Override
	public boolean joinRequest(Auth vo) {
		// TODO Auto-generated method stub
		IAuthDao authDao = sqlSession.getMapper(IAuthDao.class);
		return authDao.register(vo);
	}

	@Override
	public boolean checkExistId(String id) {
		// TODO Auto-generated method stub
		IAuthDao authDao = sqlSession.getMapper(IAuthDao.class);
		return authDao.checkExistId(id) == 0;
	}

	@Override
	public Auth getOne(String id) {
		// TODO Auto-generated method stub
		IAuthDao authDao = sqlSession.getMapper(IAuthDao.class);
		return authDao.getOne(id);
	}

	
	
}
