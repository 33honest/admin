package cn.ccrm.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.ccrm.admin.entity.Const;
import cn.ccrm.admin.entity.User;

public class UrlInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		logger.debug("访问路径:{}", request.getRequestURI());
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Const.SESSION_USER);
		/*
		if(null == user) {
			response.sendRedirect("/login.htm");
			return false;
		}
		*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {
		if(null != mv) {
			mv.addObject(Const.SESSION_QX, request.getAttribute(Const.SESSION_QX));
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
