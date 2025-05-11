package com.github.devmribeiro.api.municipios.dto;

import com.github.devmribeiro.api.municipios.model.Municipio;

public class MunicipioDTO {
	private Integer codMunicipio = null;
    private String nome = null;
    private String ufSigla = null;
    private String ufNome = null;
    private String ufRegiao = null;

    public MunicipioDTO(Municipio municipio) {
        this.codMunicipio = municipio.getCodMunicipio();
        this.nome = municipio.getNome();
        if (municipio.getUf() != null) {
            this.ufSigla = municipio.getUf().getUfSigla();
            this.ufNome = municipio.getUf().getUfNome();
            this.ufRegiao = municipio.getUf().getUfRegiao();
        }
    }

    public Integer getCodMunicipio() {
        return codMunicipio;
    }

    public String getNome() {
        return nome;
    }

    public String getUfSigla() {
        return ufSigla;
    }

    public String getUfNome() {
        return ufNome;
    }

	public String getUfRegiao() {
		return ufRegiao;
	}
}