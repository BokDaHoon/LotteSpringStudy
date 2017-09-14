package com.ldcc.sirius.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldcc.sirius.service.AuthService;
import com.ldcc.sirius.vo.Auth;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

	
	@Autowired
	private AuthService authService;
	

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String main(Model model, HttpSession session){
		return "/auth/default";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpSession session){
		return "/auth/login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/loginRequest", method = RequestMethod.POST)
	public HashMap<String, String> loginRequest(Model model, Auth auth, HttpSession session){
		HashMap<String, String> map = new HashMap<String, String>();
		boolean isMatched = authService.loginRequest(auth.getId(), auth.getPw());
		if(!isMatched){ 
			map.put("code", "-1");
			map.put("result", "NotMatchingAuth");
		} else {
			map.put("code", "1");
			map.put("result", "SUCCESS");
			auth = authService.getOne(auth.getId());
			session.setAttribute("auth", auth);
		}
		
		return map;
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model, HttpSession session){
		return "/auth/join";
	}
	
	@ResponseBody
	@RequestMapping(value = "/joinRequest", method = RequestMethod.POST)
	public HashMap<String, String> joinRequest(Model model, Auth auth, HttpSession session){
		HashMap<String, String> map = new HashMap<String, String>();
		
		if(!authService.checkExistId(auth.getId())){
			map.put("code", "-1");
			map.put("result", "Exist Id");
		}
		else if(authService.joinRequest(auth)){
			map.put("code", "1");
			map.put("result", "SUCCESS");
		}
		
		return map;
	}
	
	@RequestMapping(value = "/logoutRequest", method = RequestMethod.POST)
	public void logoutRequest(HttpSession session, HttpServletResponse res){
		authService.logoutRequest(session);
		try {
			res.sendRedirect("/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
