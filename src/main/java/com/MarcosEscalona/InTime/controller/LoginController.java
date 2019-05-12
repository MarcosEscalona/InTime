package com.MarcosEscalona.InTime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value="/loginInTime", method=RequestMethod.GET)
	public String loginInTime() {
			
			return "login/formLogin";
	}
	
	
	
}
