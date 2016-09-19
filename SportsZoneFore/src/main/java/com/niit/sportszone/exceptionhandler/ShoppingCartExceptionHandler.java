package com.niit.sportszone.exceptionhandler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ShoppingCartExceptionHandler {
	
private static final Logger logger = LoggerFactory.getLogger(ShoppingCartExceptionHandler.class);
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request, Exception e){
		logger.error("SQLException Occured:: URL="+request.getRequestURL());
		logger.error("SQLException Occured:: Exception="+e.getMessage());
	      ModelAndView mv = new ModelAndView("database_error");
	      mv.addObject("error", e.getMessage());
		
		return mv;
	}
	
	@ExceptionHandler(QuerySyntaxException.class)
	public String handleQuerySyntaxException(HttpServletRequest request, Exception e){
		logger.error("Query Syntax Exception Occured:: URL="+request.getRequestURL());
		logger.error("Query Syntax Occured:: Exception="+e.getMessage());
		 ModelAndView mv = new ModelAndView("database_error");
	     mv.addObject("error", e.getMessage());
		
		return "database_error";
	}
	@ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView noHandlerException(HttpServletRequest request, Exception e)   {
		logger.error("NoHandlerException Occured:: URL="+request.getRequestURL());
		logger.error("NoHandlerException Occured:: Exception="+e.getMessage());
            ModelAndView mav = new ModelAndView("/error");
            mav.addObject("message", "Not handler found.  please contact administration");
            
            mav.addObject("exception", e);  
            return mav;
    }
		
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(HttpServletRequest request, Exception e){
		logger.error("IOException handler executed");
		logger.error("IOException Occured:: Exception="+e.getMessage());
	      
		  ModelAndView mav = new ModelAndView("/404");
          mav.addObject("message", "Not handler found.  please contact administration");
          
          mav.addObject("exception", e);  
          return mav;
		
	}



}