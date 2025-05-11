package com.github.devmribeiro.api.municipios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "municipio")
public class Municipio {

	@Id
	@Column(name = "mun_cod")
	private Integer codMunicipio = null;

	@Column(name = "mun_nome")
	private String nome = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mun_uf_cod", referencedColumnName = "uf_cod")
    private UnidadeFederativa uf;

	public Municipio() { }
	
	public Municipio(Long municipioId, Integer codMunicipio, String nome, UnidadeFederativa uf) {
		this.codMunicipio = codMunicipio;
		this.nome = nome;
		this.uf = uf;
	}

	public Integer getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(Integer codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UnidadeFederativa getUf() {
		return uf;
	}

	public void setUf(UnidadeFederativa uf) {
		this.uf = uf;
	}
}