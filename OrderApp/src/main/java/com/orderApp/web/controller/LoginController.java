package com.orderApp.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	/********************************LOGIN ****************************/
	@GetMapping(path = "/login")
	public String login() {
		return "login";
	}
	@GetMapping(path = "/")
	public String applogin() {
		return "login";
	}
	
	/********************************LOGOUT ***************************/
	@GetMapping(path="/logout")
	public String logout() {
	return "login";
	}
	
	/*******************************ACCESS DENIED **********************/
	@GetMapping(path = "accessdenied")
	public ModelAndView accessdenied(Principal principal, ModelAndView mv) {
		mv.addObject("username", principal.getName());
		mv.setViewName("403");
		return mv;
	}
}
