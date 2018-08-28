package cn.ccrm.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import cn.ccrm.admin.common.CommonConst;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler({RuntimeException.class})
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processException(RuntimeException exception, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView m = new ModelAndView();
		
		m.addObject("runtimeException", exception.getMessage());
		m.addObject("statusCode", response.getStatus());
		m.setViewName(CommonConst.VIEWPREFIX_NAME + "authenticated/fail");
		return m;
	}
	
	@ExceptionHandler({Exception.class})
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processException(Exception exception, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView m = new ModelAndView();
		
		m.addObject("runtimeException", exception.getMessage());
		m.addObject("statusCode", response.getStatus());
		m.setViewName(CommonConst.VIEWPREFIX_NAME + "authenticated/fail");
		return m;
	}
	
}
