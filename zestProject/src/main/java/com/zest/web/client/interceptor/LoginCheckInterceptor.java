package com.zest.web.client.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zest.web.client.model.client.ClientVO;

//로그인 체크 인터셉터
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {

		//HttpSession 이 존재하면 현재 세션을 반환하고 그렇지 않으면 null 값을 넘김.
		HttpSession session = request.getSession(false);
	
		// 만약 세션이 널이면
		if (session == null) {
			logger.info("세션이 없습니다.");
			return true;
		}
		
		logger.info(session.getId());

		// 아니면 해당 클라이언트를 가져온다.
		if(session.getAttribute("client") != null) {
		ClientVO clientVO = (ClientVO) session.getAttribute("client");		
		logger.info(clientVO.toString());
		}
		// 클라이언트로 저장된 세션의 값이 없으면
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("로그인 인터셉터 작동");
		if (request.getSession().getAttribute("client") != null) {					
			ClientVO clientVO = (ClientVO) request.getSession().getAttribute("client");
			logger.info(clientVO.toString());
			
			if(modelAndView == null) {
				modelAndView = new ModelAndView();
				modelAndView.addObject("client",clientVO);
			}
			//modelAndView.addObject("login", "success");
		}else {
			//modelAndView.addObject("login", "logout");
		}
		super.postHandle(request, response, handler, modelAndView);
	}

}
