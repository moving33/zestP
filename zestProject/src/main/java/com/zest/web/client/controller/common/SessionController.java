package com.zest.web.client.controller.common;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//세션 컨트롤러
@Controller
public class SessionController {
	
	  
    @RequestMapping(value="session", method = RequestMethod.POST)
    @ResponseBody
    public String viewMainPage(HttpSession session) {       
       String sessionj = "0";       
       
       if(session.getAttribute("client") != null) {
          sessionj = "1";
          
       }else {
          System.out.println("세션 없음:");
       }
       
       return sessionj;
    }
}
	

