package com.picoto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisController {

	PaisService paisService;

	@Autowired
	PaisController(PaisService paisService) {
		this.paisService = paisService;
	}

	@RequestMapping(value = "/paises/", method = RequestMethod.GET)
	public ResponseEntity<List<Pais>> getPaises() {
		List<Pais> paises = paisService.findAll();
		if (paises.isEmpty()) {
			return new ResponseEntity<List<Pais>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Pais>>(paises, HttpStatus.OK);
	}
}
