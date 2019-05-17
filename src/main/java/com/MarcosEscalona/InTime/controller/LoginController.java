package com.MarcosEscalona.InTime.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping(value = "/loginInTime", method = RequestMethod.GET)
	public String loginInTime() {

		// Utilidad para encriptar contraseñas
		String password = "1234";
		String encriptado = encoder.encode(password);
		System.out.println("Password encriptado: " + encriptado);
		
		return "login/formLogin";
	}
	
	
	

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {

		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		
		return "redirect:/";

	}

}
