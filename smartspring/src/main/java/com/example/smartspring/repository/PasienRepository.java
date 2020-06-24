package com.example.smartspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.smartspring.model.PasienModel;

// Jparepository tabel db wajib di import type variable primary key tabelnya
public interface PasienRepository extends JpaRepository<PasienModel, String>{
	//@Query("select * from pasienModel") List<PasienModel> bacaData();
	//@Query("select p from pasienModel p where p.namaPasien like %?1%")
	//List<PasienModel> cariNama(String namaPasien);
	@Query(value = "SELECT * FROM T_PASIEN ORDER BY K_NAMA_PASIEN DESC" ,
		 nativeQuery = true)List<PasienModel> urutkanData();
	
	@Query("SELECT P FROM PasienModel P WHERE P.namaPasien LIKE '%j%' ")
	List<PasienModel> cariDataYangMengandung();
}
