package com.springboot.jpa.hibernate.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.hibernate.model.MMnrc;
import com.springboot.jpa.hibernate.service.INrcService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class MMnrcController {

	private final INrcService nrcService;

	public MMnrcController(INrcService nrcService) {
		this.nrcService = nrcService;
	}

	@PostMapping("/mmnrcs")
	public ResponseEntity<MMnrc> saveMMnrc(@RequestBody MMnrc mmnrc) {
		MMnrc savedMMnrc = nrcService.saveMMnrc(mmnrc);
		return new ResponseEntity<>(savedMMnrc, HttpStatus.CREATED);
	}

	@PutMapping("/mmnrcs/{id}")
	public String updateMmnrc(@PathVariable Long id, @RequestBody MMnrc mmnrc) {
		try {
			return nrcService.updateMmnrc(mmnrc, id);

		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR + e.getMessage();
		}
	}

	@DeleteMapping("/mmnrcs/{id}")
	public String deleteMmnrc(@PathVariable Long id) {
		try {

			return nrcService.deleteMmnrc(id);

		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR + e.getMessage();
		}
	}

	@DeleteMapping("/mmnrcs")
	public String deleteAllMmnrcs() {
		try {

			return nrcService.deleteAllMmnrcs() + HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR + e.getMessage();
		}
	}

	@GetMapping("/mmnrcs/{id}")
	public ResponseEntity<MMnrc> getDepartmentById(@PathVariable("id") Long id) {
//		MMnrc mmnrc = nrcService.getMmnrcById(id);
//		if (mmnrc == null) {
//			// return (ResponseEntity<MMnrc>) ResponseEntity.noContent();
////			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Resource not found!!");
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} else {
////				return ResponseEntity.ok(mmnrc);
//			return nrcService.getMMnrcById(id);
//		}
		return nrcService.getMMnrcById(id);
	}

	@GetMapping("/mmnrcs")
	public ResponseEntity<List<MMnrc>> getAllMMnrcs() {
		List<MMnrc> mmnrcList = nrcService.getAllMMnrcs();
		if (mmnrcList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<>(mmnrcList, HttpStatus.OK);
		}

	}

}