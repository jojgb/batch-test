package com.example.smartspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/office")
public class OfficeController {
	@RequestMapping("/utamaoffice")
	public String utamaOffice() {
		
		String html = "/utamaoffice";
		return html ;
		
	}
	@RequestMapping("/penjualan")
	public String penjualanOffice() {
		
		String html = "/office/penjualanOffice";
		return html ;
		
	}
	@RequestMapping("/karyawan")
	public String karyawanOffice() {
		
		String html = "/office/karyawan/karyawanOffice";
		return html ;
		
	}
}
