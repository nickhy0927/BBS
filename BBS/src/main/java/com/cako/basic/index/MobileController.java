package com.cako.basic.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/outLink/outLogin")
public class MobileController {

	@RequestMapping(value = "/mobileApplication.app")
	public void mobileApplication() {
		System.out.println("这是请求的数据");
	}
}
