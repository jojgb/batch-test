package com.example.smartspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smartspring.model.PasienModel;
import com.example.smartspring.repository.PasienRepository;

@Service
@Transactional
public class PasienService {
		@Autowired //digunakan untuk mengambil fungsi fungsi yang ada di class lain
		private PasienRepository pasienRepository; //membuat variabel baru dari class PasienRepository
		//this memanggil class , this.pasienRepository berarti memanggil Pasien Repository dalam kelas Pasien Service
		public void create(PasienModel pasienModel) {
			this.pasienRepository.save(pasienModel);// disimpan kemana			
		}
		
		public List<PasienModel> readData(){
			return this.pasienRepository.findAll();
		}
		public void update(PasienModel pasienModel) {
			 this.pasienRepository.save(pasienModel);
		}
		//delete
		public void remove(String kodePasien) {
			this.pasienRepository.deleteById(kodePasien);
		}
		// tampilkan dan urutkan
		public List<PasienModel> sortData() {
			return this.pasienRepository.urutkanData();
		}
		
		public List<PasienModel> cariPasien() {
			return this.pasienRepository.cariDataYangMengandung();
		}
}
