package br.com.ada.catalogoFilmes.service;

import br.com.ada.catalogoFilmes.entity.Filme;
import br.com.ada.catalogoFilmes.repository.FilmeRepository;

public class FilmeService {

	private FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public void cadastrarFilme(String nome, String dataLancamento, double orcamento, String descricao) {
        Filme filme = new Filme(nome, dataLancamento, orcamento, descricao);
        filmeRepository.adicionarFilme(filme);
    }

    public void removerFilme(Integer identificador) {
        Filme filme = filmeRepository.buscarDiretor(identificador);
        if (filme != null) {
            filmeRepository.removeFilme(filme);
        }
    }

    public Filme buscarFilme(Integer identificador) {
        return filmeRepository.buscarDiretor(identificador);
    }
}
