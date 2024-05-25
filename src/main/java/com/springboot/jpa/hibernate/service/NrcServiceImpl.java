package com.springboot.jpa.hibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.jpa.hibernate.model.MMnrc;
import com.springboot.jpa.hibernate.respository.INrcRepository;

@Service
public class NrcServiceImpl implements INrcService {

	private final INrcRepository nrcRepository;

	public NrcServiceImpl(INrcRepository nrcRepository) {
		this.nrcRepository = nrcRepository;
	}

	@Override
	public MMnrc saveMMnrc(MMnrc mmnrc) {
		return nrcRepository.save(mmnrc);
	}

	@Override
	public ResponseEntity<MMnrc> getMMnrcById(@PathVariable("id") Long id) {

		Optional<MMnrc> mmnrcData = nrcRepository.findById(id);

		if (mmnrcData.isPresent()) {
			return new ResponseEntity<>(mmnrcData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public List<MMnrc> getAllMMnrcs() {

		return nrcRepository.findAll();
	}

	@Override
	public MMnrc getMmnrcById(Long id) {

		return nrcRepository.getReferenceById(id);
	}

	@Override
	public String updateMmnrc(MMnrc nrc, Long id) {
//		Optional<MMnrc> mmnrcData = nrcRepository.findById(id);
//
//		if (mmnrcData.isPresent()) {
//			nrc.setId(id);
//			nrcRepository.save(nrc);
//			return "id : " + nrc.getId() + " is updated.";
//		} else {
//			return id + " not exist";
//		}
		if (nrcRepository.existsById(id)) {
			nrc.setId(id);
			nrcRepository.save(nrc);
			return "id : " + nrc.getId() + " is updated.";
		} else {
			return id + " not exist";
		}

	}

	@Override
	public String deleteMmnrc(Long id) {

//		Optional<MMnrc> mmnrcData = nrcRepository.findById(id);

//		if (mmnrcData.isPresent()) {
//			nrcRepository.delete(nrcRepository.getReferenceById(id));
//			return id + " deleted.";
//		} else {
//			return id + " not exist";
//		}

		if (nrcRepository.existsById(id)) {
			nrcRepository.delete(nrcRepository.getReferenceById(id));
			return id + " deleted.";
		} else {
			return id + " not exist";
		}

	}

	@Override
	public String deleteAllMmnrcs() {
		if (nrcRepository.count() > 0) {
			nrcRepository.deleteAll();
			return "All data deleted!";
		} else {
			return "Table is empty, no data is deleted. ";
		}

	}

}
