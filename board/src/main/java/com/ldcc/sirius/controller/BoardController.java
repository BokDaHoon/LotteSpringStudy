package com.ldcc.sirius.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ldcc.sirius.service.BoardService;
import com.ldcc.sirius.vo.Auth;
import com.ldcc.sirius.vo.Board;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		ArrayList<Board> boardList = boardService.getList();
		model.addAttribute("boardlist", boardList);
		return "/board/index";
	}
	
	@RequestMapping(value = "/read/{no}", method = RequestMethod.GET)
	public String read(Model model, @PathVariable("no") int no, HttpSession session) {
		Board vo = boardService.getOne(no);
		model.addAttribute("vo", vo);
		
		Auth auth = (Auth)(session.getAttribute("auth"));
		model.addAttribute("id", auth.getId());
		
		return "/board/read";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Model model) {
		return "/board/write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeRequest(Model model, Board vo, HttpSession session) {
		Auth auth = (Auth) session.getAttribute("auth");
		vo.setWriter(auth.getName());
		vo.setWriter_id(auth.getId());
		System.out.println("write : " + boardService.write(vo));
		
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/edit/{no}", method = RequestMethod.GET)
	public String edit(Model model, HttpSession session,  @PathVariable("no") int no) {
		Board board = boardService.getOne(no);
		Auth auth = (Auth) session.getAttribute("auth");
		if(!board.getWriter_id().equals(auth.getId()))
			new Exception("NotMatchingWriter");

		model.addAttribute("board", board);
		return "/board/edit";
	}
	
	@RequestMapping(value = "/edit/{no}", method = RequestMethod.POST)
	public String editRequest(Model model, Board newOne, HttpSession session,  @PathVariable("no") int no) {
		Board board = boardService.getOne(no);
		Auth auth = (Auth) session.getAttribute("auth");
		if(!board.getWriter_id().equals(auth.getId()))
			new Exception("NotMatchingWriter");
		newOne.setNo(no);
		newOne.setWriter(board.getWriter());
		newOne.setWriter_id(board.getWriter_id());
		boardService.edit(newOne);
		return "redirect:/board/read/" + no;
	}
	
	@RequestMapping(value = "/delete/{no}", method = RequestMethod.POST)
	public String deleteRequest(@PathVariable("no") int no, HttpSession session){
		Board board = boardService.getOne(no);
		Auth auth = (Auth) session.getAttribute("auth");
		if(!board.getWriter_id().equals(auth.getId()))
			new Exception("NotMatchingWriter");
		
		boardService.delete(no);
		return "redirect:/board";
	}
}
