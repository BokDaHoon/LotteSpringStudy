package com.ldcc.sirius.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ldcc.sirius.vo.Board;

public interface BoardService {

	public ArrayList<Board> getList();
	
	public Board getOne(int no);
	
	public int write(Board vo);
	
	public int edit(Board vo);

	public boolean delete(int no);
	
}
