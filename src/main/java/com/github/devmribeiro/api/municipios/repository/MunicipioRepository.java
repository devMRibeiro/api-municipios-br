package com.github.devmribeiro.api.municipios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.devmribeiro.api.municipios.model.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
	Municipio findByNome(String nome);

	@Query(value = "SELECT m.* FROM municipio m JOIN FETCH unidade_federativa uf ON m.mun_uf_cod = uf.uf_cod WHERE uf.uf_sigla = :sigla", nativeQuery = true)
	List<Municipio> findByUfSigla(@Param("sigla") String sigla);
	
	@Query("SELECT m FROM Municipio m JOIN FETCH m.uf")
	List<Municipio> findAll();
}