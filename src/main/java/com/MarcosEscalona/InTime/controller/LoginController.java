package com.MarcosEscalona.InTime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.MarcosEscalona.InTime.service.IEmpleadoService;


@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IEmpleadoService serviceEmpleado;
	
	@RequestMapping(value="/loginInTime", method=RequestMethod.GET)
	public String loginInTime() {
			
			return "login/formLogin";
	}
	
	
	
}
