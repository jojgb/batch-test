package com.example.smartspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HobiController {
	@RequestMapping("/hobi")
	public String Hobby() {
		String hobby = "Hobi";
		return hobby;
	}
}
