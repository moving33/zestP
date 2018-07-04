package com.zest.web.admin.controller.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/admin/index")
	public String test() {
		return "/admin/index";
	}
	
}
