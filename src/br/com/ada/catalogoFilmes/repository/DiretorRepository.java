package br.com.ada.catalogoFilmes.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.ada.catalogoFilmes.entity.Diretor;

public class DiretorRepository {

	private List<Diretor> diretorBanco;

	public DiretorRepository() {
		this.diretorBanco = new ArrayList<>();
	}

	public void adicionarDiretor(Diretor diretor) {
		this.diretorBanco.add(diretor);
	}

	public void removeDiretor(Diretor diretor) {
		Iterator<Diretor> iterator = diretorBanco.iterator();
		while (iterator.hasNext()) {
			Diretor novo = iterator.next();
			if (novo.getIdentificador().equals(diretor.getIdentificador())) {
				iterator.remove();
				break;
			}
		}
	}

	public Diretor buscarDiretor(Integer identificador) {
		for (Diretor diretor : diretorBanco) {
			if (diretor.getIdentificador().equals(identificador)) {
				return diretor;
			}
		}
		return null;
	}
	
	 public List<Diretor> listarDiretores() {
	        return diretorBanco;
	    }
}
