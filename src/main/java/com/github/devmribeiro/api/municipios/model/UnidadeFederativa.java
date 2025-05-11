package com.github.devmribeiro.api.municipios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidade_federativa")
public class UnidadeFederativa {

	@Id
	@Column(name = "uf_id")
	private Integer ufId = null;

	@Column(name = "uf_cod")
	private Integer ufCod = null;

	@Column(name = "uf_nome")
	private String ufNome = null;

	@Column(name = "uf_sigla")
	private String ufSigla = null;

	@Column(name = "uf_regiao")
	private String ufRegiao = null;

	public UnidadeFederativa() { }

	public UnidadeFederativa(Integer ufId, Integer ufCod, String ufNome, String ufSigla, String ufRegiao) {
		this.ufId = ufId;
		this.ufCod = ufCod;
		this.ufNome = ufNome;
		this.ufSigla = ufSigla;
		this.ufRegiao = ufRegiao;
	}

	public Integer getUfId() {
		return ufId;
	}

	public void setUfId(Integer ufId) {
		this.ufId = ufId;
	}

	public Integer getUfCod() {
		return ufCod;
	}

	public void setUfCod(Integer ufCod) {
		this.ufCod = ufCod;
	}

	public String getUfNome() {
		return ufNome;
	}

	public void setUfNome(String ufNome) {
		this.ufNome = ufNome;
	}

	public String getUfSigla() {
		return ufSigla;
	}

	public void setUfSigla(String ufSigla) {
		this.ufSigla = ufSigla;
	}

	public String getUfRegiao() {
		return ufRegiao;
	}

	public void setUfRegiao(String ufRegiao) {
		this.ufRegiao = ufRegiao;
	}
}