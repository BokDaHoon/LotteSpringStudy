package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");
		
		String seq = request.getParameter("seq");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");
		BoardVO board = boardService.getBoard(vo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", board);
		mv.setViewName("getBoard");
		
		return mv;
	}

}
