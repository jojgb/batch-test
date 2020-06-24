package com.example.smartspring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartspring.model.PasienModel;
import com.example.smartspring.service.PasienService;

@RestController
@RequestMapping("/api/pasien")
public class PasienApi {
	
	@Autowired
	private PasienService pasienService;
	// POST || INSERT
	@PostMapping("/post") // digunakan untuk memapping suatu method sebagai fungsi insert data dalam API
	@ResponseStatus(code= HttpStatus.CREATED)// HTTP status,untuk memberikan info dari status http sukses atau tidak
	public Map<String, Object> postMapping(@RequestBody PasienModel pasienModel){
	
	this.pasienService.create(pasienModel);// ketika data ditambahkan akan masuk ke pasien model
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("success", Boolean.TRUE);
	map.put("pesan", "datanya sudah masuk");
	
	
		return map;
	}
	// GET || READ
	@GetMapping("/get")
	@ResponseStatus(code=HttpStatus.OK)
	public List<PasienModel> getMapping(){
		List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
		pasienModelList = this.pasienService.readData();
		return pasienModelList;
	}
	
	// PUT || UPDATE
	@PutMapping("/put")
	@ResponseStatus(code=HttpStatus.OK)
	public Map<String, Object>  putMapping(@RequestBody PasienModel pasienModel) {
		this.pasienService.update(pasienModel);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sukses", Boolean.TRUE);
		map.put("message", "datanya berhasil diubah");
			return map;
	}
	
	@DeleteMapping("/delete/{kodePasien}")
	public Map<String, Object> remove(@PathVariable String kodePasien) {
		this.pasienService.remove(kodePasien);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sukses", Boolean.TRUE);
		map.put("delete", "datanya berhasil diubah");
		return map;
	}
	
	// GET || READ
	@GetMapping("/sort")
	@ResponseStatus(code=HttpStatus.OK)
	public List<PasienModel> sortMapping(){
		List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
		pasienModelList = this.pasienService.sortData();
		return pasienModelList;
	}
	
	@GetMapping("/getNamaLike")
	@ResponseStatus(code=HttpStatus.OK)
	public List<PasienModel> getNamaLike(){
		List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
		pasienModelList = this.pasienService.cariPasien();
		return pasienModelList;
	}
}
