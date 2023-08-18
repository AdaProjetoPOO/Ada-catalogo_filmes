package br.com.ada.catalogoFilmes.service;

import br.com.ada.catalogoFilmes.entity.Diretor;
import br.com.ada.catalogoFilmes.enuns.Sexo;
import br.com.ada.catalogoFilmes.repository.DiretorRepository;

public class DiretorService {

    private DiretorRepository diretorRepository;

    public DiretorService(DiretorRepository diretorRepository) {
        this.diretorRepository = diretorRepository;
    }

    public void cadastrarDiretor(String nome, Integer idade, Sexo sexo, String nomeProfissional) {
        Diretor diretor = new Diretor(nome, idade, sexo, null, nomeProfissional);
        diretorRepository.adicionarDiretor(diretor);
    }

    public void removerDiretor(Integer identificador) {
        Diretor diretor = diretorRepository.buscarDiretor(identificador);
        if (diretor != null) {
            diretorRepository.removeDiretor(diretor);
        }
    }

    public Diretor buscarDiretor(Integer identificador) {
        return diretorRepository.buscarDiretor(identificador);
    }
}
