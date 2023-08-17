package br.com.ada.catalogoFilmes.entity;

import java.util.Objects;

import br.com.ada.catalogoFilmes.enuns.Sexo;


public class Diretor extends Pessoa{
	
	private static Integer ultimoIdentificador = 0;
	private Integer identificador;
	private String nomeProfissional;
	
	public Diretor(String nome, Integer idade, Sexo sexo, Integer identificador, String nomeProfissional) {
		super(nome, idade, sexo);
		this.identificador = ++ultimoIdentificador;
		this.identificador = identificador;
		this.nomeProfissional = nomeProfissional;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getNomeProfissional() {
		return nomeProfissional;
	}

	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificador, nomeProfissional);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diretor other = (Diretor) obj;
		return Objects.equals(identificador, other.identificador)
				&& Objects.equals(nomeProfissional, other.nomeProfissional);
	}

	@Override
	public String toString() {
		return "Diretor [identificador=" + identificador + ", nomeProfissional=" + nomeProfissional + "]";
	}	

}
