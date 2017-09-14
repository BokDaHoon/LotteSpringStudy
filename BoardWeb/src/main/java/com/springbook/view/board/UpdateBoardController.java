package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 수정 처리");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");
		boardService.updateBoard(vo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:getBoardList.do");
		return mv;
	}

}
