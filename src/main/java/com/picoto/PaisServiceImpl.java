package com.picoto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired
	PaisRepository paisRepository;

	public List<Pais> findAll() {
		return paisRepository.findAll();
	}

}
