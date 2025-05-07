package com.github.devmribeiro.api.municipios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "municipio")
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "municipio_id")
	private Long municipioId = null;

	@Column(name = "cod_mun")
	private Integer codMunicipio = null;

	@Column(name = "nome_mun")
	private String nome = null;

	@Column(name = "sigla_uf")
	private String uf = null;

	public Municipio(Long municipioId, Integer codMunicipio, String nome, String uf) {
		this.municipioId = municipioId;
		this.codMunicipio = codMunicipio;
		this.nome = nome;
		this.uf = uf;
	}

	public Long getMunicipioId() {
		return municipioId;
	}

	public Integer getCodMunicipio() {
		return codMunicipio;
	}

	public String getNome() {
		return nome;
	}

	public String getUf() {
		return uf;
	}
}