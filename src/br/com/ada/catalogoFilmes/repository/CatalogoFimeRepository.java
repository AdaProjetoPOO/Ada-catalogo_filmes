package br.com.ada.catalogoFilmes.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.ada.catalogoFilmes.entity.CatalogoFilme;

public class CatalogoFimeRepository {

	private List<CatalogoFilme> catalogoFilmeBanco;

	public CatalogoFimeRepository() {
		this.catalogoFilmeBanco = new ArrayList<>();
	}

	public void adicionarCatalogoFime(CatalogoFilme catalogoFilme) {
		this.catalogoFilmeBanco.add(catalogoFilme);
	}

	public void removeCatalogoFime(CatalogoFilme catalogoFilme) {
		Iterator<CatalogoFilme> iterator = catalogoFilmeBanco.iterator();
		while (iterator.hasNext()) {
			CatalogoFilme novo = iterator.next();
			if (novo.getIdentificador().equals(catalogoFilme.getIdentificador())) {
				iterator.remove();
				break;
			}
		}
	}

	public CatalogoFilme buscarCatalogoFime(Integer identificador) {
		for (CatalogoFilme catalogoFilme : catalogoFilmeBanco) {
			if (catalogoFilme.getIdentificador().equals(identificador)) {
				return catalogoFilme;
			}
		}
		return null;
	}

	public List<CatalogoFilme> getCatalogoFilmeBanco() {
		return catalogoFilmeBanco;
	}
}
