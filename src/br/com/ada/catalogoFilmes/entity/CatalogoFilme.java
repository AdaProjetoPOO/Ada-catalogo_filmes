package br.com.ada.catalogoFilmes.entity;

import java.util.List;
import java.util.Objects;

public class CatalogoFilme {

	private static Integer ultimoIdentificador = 0;
	private Integer identificador;
	private List<Filme> filmes;

	public CatalogoFilme() {}

	public CatalogoFilme(List<Filme> filmes) {
		this.identificador = ++ultimoIdentificador;
		this.filmes = filmes;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmes, identificador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatalogoFilme other = (CatalogoFilme) obj;
		return Objects.equals(filmes, other.filmes) && Objects.equals(identificador, other.identificador);
	}

	@Override
	public String toString() {
		return "CatalogoFilme [identificador=" + identificador + ", filmes=" + filmes + "]";
	}
}

