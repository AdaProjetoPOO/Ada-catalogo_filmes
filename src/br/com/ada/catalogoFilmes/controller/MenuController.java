package br.com.ada.catalogoFilmes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.ada.catalogoFilmes.entity.Ator;
import br.com.ada.catalogoFilmes.entity.Diretor;
import br.com.ada.catalogoFilmes.entity.Filme;
import br.com.ada.catalogoFilmes.enuns.Sexo;
import br.com.ada.catalogoFilmes.repository.CatalogoFimeRepository;
import br.com.ada.catalogoFilmes.service.AtorService;
import br.com.ada.catalogoFilmes.service.CatalogoFilmeService;
import br.com.ada.catalogoFilmes.service.DiretorService;
import br.com.ada.catalogoFilmes.service.FilmeService;

@SuppressWarnings("unused")
public class MenuController {

	private AtorService atorService;
	private CatalogoFilmeService catalogoFilmeService;
	private DiretorService diretorService;
	private FilmeService filmeService;
	private CatalogoFimeRepository catalogoFilmeRepository;
	private Scanner scanner;

	public MenuController(AtorService atorService, CatalogoFilmeService catalogoFilmeService,
			DiretorService diretorService, FilmeService filmeService, CatalogoFimeRepository catalogoFilmeRepository) {
		this.atorService = atorService;
		this.catalogoFilmeService = catalogoFilmeService;
		this.diretorService = diretorService;
		this.filmeService = filmeService;
		this.catalogoFilmeRepository = catalogoFilmeRepository;
		this.scanner = new Scanner(System.in);
	}

	public void menuPrincipal() {
		boolean sair = false;
		while (!sair) {
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastrar Filme");
			System.out.println("2 - Pesquisar Filme");
			System.out.println("3 - Sair");
			int opcao = scanner.nextInt();
			switch (opcao) {
			case 1:
				cadastrarFilme();
				break;
			case 2:
				pesquisarFilme();
				break;
			case 3:
				sair = true;
				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
	}

	private void cadastrarFilme() {
		System.out.println("Digite o nome do filme:");
		String nome = scanner.next();
		System.out.println("Digite a data de lançamento do filme (dd/MM/yyyy):");
		String dataLancamento = scanner.next();
		System.out.println("Digite o orçamento do filme:");
		double orcamento = scanner.nextDouble();
		System.out.println("Digite a descrição do filme:");
		String descricao = scanner.next();
		Filme filme = new Filme(nome, dataLancamento, orcamento, descricao);

		boolean cadastrarAtor = true;
		while (cadastrarAtor) {
			System.out.println("Deseja cadastrar um ator para este filme? (S/N)");
			String resposta = scanner.next();
			if (resposta.equalsIgnoreCase("S")) {
				cadastrarAtor(filme);
			} else {
				cadastrarAtor = false;
			}
		}

		boolean cadastrarDiretor = true;
		while (cadastrarDiretor) {
			System.out.println("Deseja cadastrar um diretor para este filme? (S/N)");
			String resposta = scanner.next();
			if (resposta.equalsIgnoreCase("S")) {
				cadastrarDiretor(filme);
			} else {
				cadastrarDiretor = false;
			}
		}

		List<Filme> filmes = new ArrayList<>();
		filmes.add(filme);
		catalogoFilmeService.adicionarCatalogoFilme(filmes);
	}

	private void cadastrarAtor(Filme filme) {
		System.out.println("Digite o nome do ator:");
		String nome = scanner.next();
		System.out.println("Digite a idade do ator:");
		int idade = scanner.nextInt();
		System.out.println("Digite o sexo do ator (M/F/N):");
		String sexoStr = scanner.next().toUpperCase();
		Sexo sexo = Sexo.valueOf(sexoStr);
		System.out.println("Digite o nome profissional do ator:");
		String nomeProfissional = scanner.next();

		Ator ator = new Ator(nome, idade, sexo, nomeProfissional);

		filme.getAtores().add(ator);
	}

	private void cadastrarDiretor(Filme filme) {
		System.out.println("Digite o nome do diretor:");
		String nome = scanner.next();
		System.out.println("Digite a idade do diretor:");
		int idade = scanner.nextInt();
		System.out.println("Digite o sexo do diretor (M/F/N):");
		String sexoStr = scanner.next().toUpperCase();
		Sexo sexo = Sexo.valueOf(sexoStr);
		System.out.println("Digite o nome profissional do diretor:");
		String nomeProfissional = scanner.next();

		Diretor diretor = new Diretor(nome, idade, sexo, null, nomeProfissional);

		filme.setDiretor(diretor);
	}

	private void pesquisarFilme() {
		System.out.println("Digite o nome do filme:");
		String nomePesquisa = scanner.next().toLowerCase();

		List<Filme> filmesEncontrados = catalogoFilmeRepository.getCatalogoFilmeBanco().stream()
				.flatMap(catalogo -> catalogo.getFilmes().stream())
				.filter(filme -> filme.getNome().toLowerCase().contains(nomePesquisa)).collect(Collectors.toList());

		if (filmesEncontrados.isEmpty()) {
			System.out.println("Nenhum filme encontrado com esse nome.");
		} else {
			System.out.println("Filmes encontrados:");
			for (Filme filme : filmesEncontrados) {
				System.out.println(filme);
			}
		}
	}
}
