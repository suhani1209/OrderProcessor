package com.orderApp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.orderApp.model.exception.OrderNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {
	
	private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);
	
	//EXCEPTION HANDLER IN CASE ANY EXCEPTION OCCURS USER WILL SEE THE ERROR PAGE
	@ExceptionHandler(value = OrderNotFoundException.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, 
               Exception e) throws Exception {
		
		logger.error("[URL] : {}", req.getRequestURL(), e); 
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllException(HttpServletRequest req, 
               Exception e) throws Exception {
		
		logger.error("[URL] : {}", req.getRequestURL(), e); 
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("allerror");
		return mav;
	}
	
}
