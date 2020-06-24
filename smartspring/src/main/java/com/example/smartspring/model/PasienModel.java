package com.example.smartspring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


// Model digunakan untuk membuat tabel database
@Entity
@Table(name="T_PASIEN")
public class PasienModel {
	// variable method
	@Id
	@Column(name="K_KODE_PASIEN")
	private String kodePasien;
	
	@Column(name="K_NAMA_PASIEN")
	private String namaPasien;
	
	@Column(name="K_GENDER")
	private String genderPasien;
	
	@Column(name="K_KATEGORI_PASIEN")
	private String kategoriPasien;
	
	@Column(name="K_BIAYA")
	private int biaya;
	
	@Column(name="K_TANGGAL_LAHIR")
	private Date tangggalLahir ;
	
	
	public String getKodePasien() {
		return kodePasien;
	}
	public void setKodePasien(String kodePasien) {
		this.kodePasien = kodePasien;
	}
	public String getNamaPasien() {
		return namaPasien;
	}
	public void setNamaPasien(String namaPasien) {
		this.namaPasien = namaPasien;
	}
	public String getGenderPasien() {
		return genderPasien;
	}
	public void setGenderPasien(String genderPasien) {
		this.genderPasien = genderPasien;
	}
	public String getKategoriPasien() {
		return kategoriPasien;
	}
	public void setKategoriPasien(String kategoriPasien) {
		this.kategoriPasien = kategoriPasien;
	}
	public int getBiaya() {
		return biaya;
	}
	public void setBiaya(int biaya) {
		this.biaya = biaya;
	}
	public Date getTangggalLahir() {
		return tangggalLahir;
	}
	public void setTangggalLahir(Date tangggalLahir) {
		this.tangggalLahir = tangggalLahir;
	}
	
}
