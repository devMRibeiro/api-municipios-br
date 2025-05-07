package com.github.devmribeiro.api.municipios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.devmribeiro.api.municipios.model.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
	Municipio findByNome(String nome);
	List<Municipio> findByUf(String uf);
}