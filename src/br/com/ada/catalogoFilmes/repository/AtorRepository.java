package br.com.ada.catalogoFilmes.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.ada.catalogoFilmes.entity.Ator;

public class AtorRepository {

	private List<Ator> atorBanco;

	public AtorRepository() {
		this.atorBanco = new ArrayList<>();
	}
	
	public void adicionarAtor(Ator ator) {
		this.atorBanco.add(ator);
	}

	public void removerAtor(Ator ator) {
		Iterator<Ator> iterator = atorBanco.iterator();
		while (iterator.hasNext()) {
			Ator novo = iterator.next();
			if (novo.getIdentificador().equals(ator.getIdentificador())) {
				iterator.remove();
				break;
			}
		}
	}

	public Ator buscarAtor(Integer identificador) {
		for (Ator ator : atorBanco) {
			if (ator.getIdentificador().equals(identificador)) {
				return ator;
			}
		}
		return null;
	}
	
}
