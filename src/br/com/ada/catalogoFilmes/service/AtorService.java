package br.com.ada.catalogoFilmes.service;

import br.com.ada.catalogoFilmes.entity.Ator;
import br.com.ada.catalogoFilmes.enuns.Sexo;
import br.com.ada.catalogoFilmes.repository.AtorRepository;

public class AtorService {

	private AtorRepository atorRepository;

	public AtorService(AtorRepository atorRepository) {
		this.atorRepository = atorRepository;
	}

	public void cadastrarAtor(String nome, Integer idade, Sexo sexo, String nomeProfissional) {
		Ator ator = new Ator(nome, idade, sexo, nomeProfissional);
		atorRepository.adicionarAtor(ator);
	}

	public void removerAtor(Integer identificador) {
		Ator ator = atorRepository.buscarAtor(identificador);
		if (ator != null) {
			atorRepository.removerAtor(ator);
		}
	}

	public Ator buscarAtor(Integer identificador) {
		return atorRepository.buscarAtor(identificador);
	}
}
