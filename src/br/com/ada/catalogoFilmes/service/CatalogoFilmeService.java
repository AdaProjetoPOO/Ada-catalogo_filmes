package br.com.ada.catalogoFilmes.service;

import java.util.List;

import br.com.ada.catalogoFilmes.entity.CatalogoFilme;
import br.com.ada.catalogoFilmes.entity.Filme;
import br.com.ada.catalogoFilmes.repository.CatalogoFimeRepository;

public class CatalogoFilmeService {

	private CatalogoFimeRepository catalogoFilmeRepository;

	public CatalogoFilmeService(CatalogoFimeRepository catalogoFilmeRepository) {
		this.catalogoFilmeRepository = catalogoFilmeRepository;
	}

	public void adicionarCatalogoFilme(List<Filme> filmes) {
		CatalogoFilme catalogoFilme = new CatalogoFilme(filmes);
		catalogoFilmeRepository.adicionarCatalogoFime(catalogoFilme);
	}

	public void removerCatalogoFilme(Integer identificador) {
		CatalogoFilme catalogoFilme = new CatalogoFilme();
		catalogoFilme.setIdentificador(identificador);
		catalogoFilmeRepository.removeCatalogoFime(catalogoFilme);
	}

	public List<CatalogoFilme> getCatalogoFilmeBanco() {
		return catalogoFilmeRepository.getCatalogoFilmeBanco();
	}
}
