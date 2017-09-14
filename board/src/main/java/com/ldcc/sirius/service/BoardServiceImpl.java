package com.ldcc.sirius.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldcc.sirius.dao.IBoardDao;
import com.ldcc.sirius.vo.Board;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<Board> getList() {
		// TODO Auto-generated method stub
		IBoardDao boardDao = sqlSession.getMapper(IBoardDao.class);
		return boardDao.getList();
	}

	@Override
	public Board getOne(int no) {
		// TODO Auto-generated method stub
		IBoardDao boardDao = sqlSession.getMapper(IBoardDao.class);
		return boardDao.getOne(no);
	}

	@Override
	public int write(Board vo) {
		// TODO Auto-generated method stub
		IBoardDao boardDao = sqlSession.getMapper(IBoardDao.class);
		return boardDao.write(vo);
	}

	@Override
	public int edit(Board vo) {
		// TODO Auto-generated method stub
		IBoardDao boardDao = sqlSession.getMapper(IBoardDao.class);
		return boardDao.edit(vo);
	}

	@Override
	public boolean delete(int no) {
		// TODO Auto-generated method stub
		IBoardDao boardDao = sqlSession.getMapper(IBoardDao.class);
		return boardDao.delete(no);
	}

}
