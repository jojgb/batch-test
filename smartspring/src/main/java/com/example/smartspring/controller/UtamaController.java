package com.example.smartspring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtamaController {
	@RequestMapping("/")
	public String utama() {
		// Controller untuk pindah halaman
		String home = "Utama";		
		return home;
	}
	
	@RequestMapping("/login")
	public String login() {
		
		String home = "login";		
		return home;
	}
	@RequestMapping("/login/action")
	public String tologin(HttpServletRequest request , Model model) {
		
		String mintaUser = request.getParameter("username");// data dari nilai yang ada di username diberikan ke mintauser
		String mintaPass = request.getParameter("password");
		model.addAttribute("userLempar", mintaUser);//value yang ada di mintauser dikberikan ke userlempar 
		model.addAttribute("passLempar", mintaPass);
		String home = "tologin";		
		return home;
	}

	
}
