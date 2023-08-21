package br.com.ada.catalogoFilmes.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ada.catalogoFilmes.entity.Filme;
import br.com.ada.catalogoFilmes.repository.FilmeRepository;

public class FilmeService {

	private FilmeRepository filmeRepository;
	private CatalogoFilmeService catalogoFilmeService;

    public FilmeService(FilmeRepository filmeRepository, CatalogoFilmeService catalogoFilmeService) {
        this.filmeRepository = filmeRepository;
        this.catalogoFilmeService = catalogoFilmeService;
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
    
    public List<Filme> listarFilmes() {
        return filmeRepository.listarFilmes();
    }
    
    public void avaliarFilme(Integer identificadorFilme, double avaliacao) {
        Filme filme = filmeRepository.buscarDiretor(identificadorFilme);
        if (filme != null) {
            filme.getAvaliacoes().add(avaliacao);
        }
    }
    
    public List<Filme> listarFilmesMaisAvaliados() {
        return catalogoFilmeService.listarFilmes().stream()
            .sorted(Comparator.comparingDouble(this::calcularMediaAvaliacoes).reversed())
            .limit(10)
            .collect(Collectors.toList());
    }

    private double calcularMediaAvaliacoes(Filme filme) {
        return filme.getAvaliacoes().stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0);
    }
    
}
