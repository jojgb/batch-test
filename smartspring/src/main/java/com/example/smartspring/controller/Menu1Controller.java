package com.example.smartspring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.smartspring.model.PasienModel;
import com.example.smartspring.service.PasienService;

@Controller
public class Menu1Controller {
	
	@Autowired
	private PasienService pasienService;
	
	@RequestMapping("/menu/1")
	public String Menu1(HttpServletRequest request, Model model) {
		String nameNomor = request.getParameter("nomor");
		
		model.addAttribute("nomorLempar", nameNomor);
		
		String menusatu = "menu/menu1";
		return menusatu;
	}
	@RequestMapping("/pasien/create")
	public String pasienCreate(HttpServletRequest request ,Model model) throws ParseException {
		String nomorPasien = request.getParameter("nomor");
		String namaPasien = request.getParameter("nama");
		String jenisKelamin = request.getParameter("gender");
		String kategoriPasien = request.getParameter("kategori");
		int biaya =  Integer.parseInt(request.getParameter("biaya"));
		// konversi date
		
		String tanggalLahir = request.getParameter("tanggal");
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Date tanggalLahirDate = formatDate.parse(tanggalLahir);
		System.out.println(tanggalLahirDate);
		// instance Pasien Model
		PasienModel pasienModel = new PasienModel();
		// simpan ke masing masing kolom di database
		pasienModel.setKodePasien(nomorPasien);
		pasienModel.setNamaPasien(namaPasien);
		pasienModel.setGenderPasien(jenisKelamin);
		pasienModel.setKategoriPasien(kategoriPasien);
		pasienModel.setBiaya(biaya);
		pasienModel.setTangggalLahir(tanggalLahirDate);
		// save
		this.pasienService.create(pasienModel);
		// list
		this.ListPasien(model);
		String html = "/pasien/list";
		return html;
	}
	
	public void ListPasien(Model model) {
		List<PasienModel> pasienModelList =  new ArrayList<PasienModel>();
		pasienModelList = pasienService.readData();
		model.addAttribute("pasienModelList", pasienModelList);
	}
}
