package com.orderapp.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private static String out="login";
	
	//LOGIN 
	@GetMapping(path = "/login")
	public String login() {
		return out;
	}
	@GetMapping(path = "/")
	public String applogin() {
		return out;
	}
	
	//LOGOUT 
	@GetMapping(path="/logout")
	public String logout() {
	return out;
	}
	
	//ACCESS DENIED 
	@GetMapping(path = "accessdenied")
	public ModelAndView accessdenied(Principal principal, ModelAndView mv) {
		mv.addObject("username", principal.getName());
		mv.setViewName("403");
		return mv;
	}
}
