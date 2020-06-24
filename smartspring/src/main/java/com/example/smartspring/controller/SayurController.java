package com.example.smartspring.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.smartspring.service.SayurService;

@Controller
@RequestMapping(value="sayur")
public class SayurController {
	// DI - Dependency Injection
	@Autowired
	private SayurService sayurService;
	
	
	// panggil welcome.html
	@RequestMapping(value="welcome")// ini adalah urlnya di browser
	public String methodWelcome(Model model) {
		String buah1= "Mangga Arum Manis";
		String html = "sayur/welcome";// ada di folder sayur
		
		model.addAttribute("buah1Frontend", buah1);
		return html;
	}
	@RequestMapping(value="lanjut.do")
	public String methodNext(HttpServletRequest request , Model model) {
		String html = "sayur/next";
		String buah2Backend = request.getParameter("buah2Frontend");
		model.addAttribute("buahFrontEnd", buah2Backend);
		
		// instance kelas sayurservice
//		SayurService ss = new SayurService();
		String impor1 = sayurService.buahImpor();
		model.addAttribute("buahService", impor1);
;		return html;
	}
}
