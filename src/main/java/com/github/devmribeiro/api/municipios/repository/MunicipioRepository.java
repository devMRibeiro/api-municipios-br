package com.github.devmribeiro.api.municipios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.devmribeiro.api.municipios.model.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

    @Query(value = "SELECT m.* FROM municipio m WHERE m.mun_nome ILIKE :nome ESCAPE '\\'", nativeQuery = true)
    List<Municipio> findByNome(@Param("nome") String nome);

    // Ajustada a consulta para SQL nativo
    @Query(value = "SELECT m.* FROM municipio m JOIN unidade_federativa uf ON m.mun_uf_cod = uf.uf_cod WHERE uf.uf_sigla = :sigla", nativeQuery = true)
    List<Municipio> findByUfSigla(@Param("sigla") String sigla);
}