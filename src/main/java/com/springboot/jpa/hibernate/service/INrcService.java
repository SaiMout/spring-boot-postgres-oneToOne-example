package com.springboot.jpa.hibernate.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.jpa.hibernate.model.MMnrc;

@Service
public interface INrcService {
	MMnrc saveMMnrc(MMnrc mmnrc);

	ResponseEntity<MMnrc> getMMnrcById(Long id);

	List<MMnrc> getAllMMnrcs();

	MMnrc getMmnrcById(Long id);

	String updateMmnrc(MMnrc mmnrc, Long id);

	String deleteMmnrc(Long id);

	String deleteAllMmnrcs();
}  