package com.github.devmribeiro.api.municipios.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.devmribeiro.api.municipios.dto.MunicipioDTO;
import com.github.devmribeiro.api.municipios.model.Municipio;
import com.github.devmribeiro.api.municipios.repository.MunicipioRepository;

@RestController
@RequestMapping("/api/v2/municipios")
public class MunicipioController {

	private MunicipioRepository repository;

	public MunicipioController(MunicipioRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public ResponseEntity<?> get(
	        @RequestParam(name = "uf", required = false) String uf,
	        @RequestParam(name = "mun", required = false) String municipioNome) {

	    if ((uf == null || uf.isBlank()) && (municipioNome == null || municipioNome.isBlank()))
	        return ResponseEntity.badRequest().body("Informe pelo menos um UF ou Nome do Município");
	    
	    if (uf != null && !uf.isBlank()) {
	        if (uf.trim().isEmpty() || uf.length() != 2 || uf.replaceAll("[\"']", "").trim().isEmpty())
	            return ResponseEntity.badRequest().body("Informe um UF válido");
	        uf = uf.toUpperCase();
	    }
	    
	    if (municipioNome != null && municipioNome.isBlank())
	        return ResponseEntity.badRequest().body("Informe um Nome de Município válido");

	    List<Municipio> municipios;
	    if (uf != null)
	        municipios = repository.findByUfSigla(uf);
	    else
	        municipios = repository.findByNome("%" + municipioNome + "%");
	    
	    return ResponseEntity.ok(
	        municipios.stream()
	            .map(municipio -> new MunicipioDTO(municipio))
	            .collect(Collectors.toList()));
	}
}