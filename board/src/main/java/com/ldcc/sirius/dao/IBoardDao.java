package com.ldcc.sirius.dao;

import java.util.ArrayList;

import com.ldcc.sirius.vo.Board;

public interface IBoardDao {

	public ArrayList<Board> getList();
	
	public Board getOne(int no);
	
	public int write(Board vo);
	
	public int edit(Board vo);
	
	public boolean delete(int no);
}
