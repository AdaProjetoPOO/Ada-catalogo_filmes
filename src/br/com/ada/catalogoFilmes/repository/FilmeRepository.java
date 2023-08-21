package br.com.ada.catalogoFilmes.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.ada.catalogoFilmes.entity.Filme;

public class FilmeRepository {

	private List<Filme> filmeBanco;

	public FilmeRepository() {
		this.filmeBanco = new ArrayList<>();
	}

	public void adicionarFilme(Filme filme) {
		this.filmeBanco.add(filme);
	}

	public void removeFilme(Filme filme) {
		Iterator<Filme> iterator = filmeBanco.iterator();
		while (iterator.hasNext()) {
			Filme novo = iterator.next();
			if (novo.getIdentificador().equals(filme.getIdentificador())) {
				iterator.remove();
				break;
			}
		}
	}

	public Filme buscarDiretor(Integer identificador) {
		for (Filme filme : filmeBanco) {
			if (filme.getIdentificador().equals(identificador)) {
				return filme;
			}
		}
		return null;
	}
	
	public List<Filme> listarFilmes() {
	    return filmeBanco;
	}
}
