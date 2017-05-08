package com.example.controllers;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(Model model){
		
		model.addAttribute("message", "Bienvenido");
		
		return "index";
	}
	
	@GetMapping("/prueba")
	public String prueba(HttpServletRequest request, Model model){
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null){
			Arrays.stream(cookies).forEach(cookie -> System.out.println(cookie.getName() + "=" + cookie.getValue() + " age " + cookie.getMaxAge()));
		}
		
		model.addAttribute("message", "Revisando Cookies");
		
		return "index";
	}
}
