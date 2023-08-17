package br.com.ada.catalogoFilmes.entity;

import java.util.Objects;

import br.com.ada.catalogoFilmes.enuns.Sexo;


public class Ator extends Pessoa{
	
	private static Integer ultimoIdentificador = 0;
	private Integer identificador;
	private String nomeProfissional;

	public Ator(String nome, Integer idade, Sexo sexo, String nomeProfissional) {
		super(nome, idade, sexo);
		this.identificador = ++ultimoIdentificador;
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
		Ator other = (Ator) obj;
		return Objects.equals(identificador, other.identificador)
				&& Objects.equals(nomeProfissional, other.nomeProfissional);
	}

	@Override
	public String toString() {
		return "Ator [identificador=" + identificador + ", nomeProfissional=" + nomeProfissional + "]";
	}

}
