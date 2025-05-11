package com.github.devmribeiro.api.municipios.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.devmribeiro.api.municipios.dto.MunicipioDTO;
import com.github.devmribeiro.api.municipios.repository.MunicipioRepository;

@RestController
@RequestMapping("/api/v2/municipios")
public class MunicipioController {

	private MunicipioRepository repository;

	public MunicipioController(MunicipioRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public ResponseEntity<?> get(@RequestParam(name = "uf", required = false) String uf) {
	    if (uf == null)
	        return ResponseEntity.ok(repository
	        		.findAll()
	        		.stream()
	        		.map(municipio -> new MunicipioDTO(municipio))
	        		.toList());

	    if (uf.trim().isEmpty() || uf.length() > 2 || uf.replaceAll("[\"']", "").trim().isEmpty())
	        return ResponseEntity.badRequest().body(new BadRequestException("Informe um UF válido"));

	    return ResponseEntity.ok(repository
	    		.findByUfSigla(uf.toUpperCase())
	    		.stream()
	    		.map(municipio -> new MunicipioDTO(municipio))
	    	    .toList());
	}
}