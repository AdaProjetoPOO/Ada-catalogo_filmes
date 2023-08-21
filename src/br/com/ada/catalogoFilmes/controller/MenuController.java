package br.com.ada.catalogoFilmes.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.ada.catalogoFilmes.entity.Ator;
import br.com.ada.catalogoFilmes.entity.Diretor;
import br.com.ada.catalogoFilmes.entity.Filme;
import br.com.ada.catalogoFilmes.enuns.Sexo;
import br.com.ada.catalogoFilmes.repository.CatalogoFimeRepository;
import br.com.ada.catalogoFilmes.repository.FilmeRepository;
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
	private FilmeRepository filmeRepository;
	private Scanner scanner;

	public MenuController(AtorService atorService, CatalogoFilmeService catalogoFilmeService,
			DiretorService diretorService, FilmeService filmeService, CatalogoFimeRepository catalogoFilmeRepository,
			FilmeRepository filmeRepository) {
		this.atorService = atorService;
		this.catalogoFilmeService = catalogoFilmeService;
		this.diretorService = diretorService;
		this.filmeService = filmeService;
		this.catalogoFilmeRepository = catalogoFilmeRepository;
		this.filmeRepository = filmeRepository;
		this.scanner = new Scanner(System.in);
	}

	public void menuPrincipal() {
		boolean sair = false;
		while (!sair) {
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastrar Ator");
			System.out.println("2 - Cadastrar Diretor");
			System.out.println("3 - Cadastrar Filme");
			System.out.println("4 - Avaliar Filme");
			System.out.println("5 - Filmes mais avaliados");
			System.out.println("6 - Listar Filmes");
			System.out.println("7 - Sair");
			int opcao = scanner.nextInt();
			switch (opcao) {
			case 1:
				cadastrarAtor();
				break;
			case 2:
				cadastrarDiretor();
				break;
			case 3:
				cadastrarFilme();
				break;
			case 4:
				avaliarFilme();
				break;
			case 5:
				filmesMaisAvaliados();
				break;
			case 6:
				listarFilmes();
				break;
			case 7:
				sair = true;
				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
	}

	private void cadastrarAtor() {
		System.out.println("Digite o nome do ator:");
		String nome = scanner.next();
		System.out.println("Digite a idade do ator:");
		int idade = scanner.nextInt();
		System.out.println("Digite o sexo do ator (M/F/N):");
		String sexoStr = scanner.next().toUpperCase();
		Sexo sexo = Sexo.valueOf(sexoStr);
		System.out.println("Digite o nome profissional do ator:");
		String nomeProfissional = scanner.next();

		atorService.cadastrarAtor(nome, idade, sexo, nomeProfissional);
	}

	private void cadastrarDiretor() {

		System.out.println("Digite o nome do diretor:");
		String nome = scanner.next();
		System.out.println("Digite a idade do diretor:");
		int idade = scanner.nextInt();
		System.out.println("Digite o sexo do diretor (M/F/N):");
		String sexoStr = scanner.next().toUpperCase();
		Sexo sexo = Sexo.valueOf(sexoStr);
		System.out.println("Digite o nome profissional do diretor:");
		String nomeProfissional = scanner.next();

		diretorService.cadastrarDiretor(nome, idade, sexo, nomeProfissional);
	}

	private void avaliarFilme() {
		System.out.println("Escolha um filme para avaliar:");
		List<Filme> filmes = catalogoFilmeService.listarFilmes();
		for (int i = 0; i < filmes.size(); i++) {
			System.out.println((i + 1) + " - " + filmes.get(i).getNome());
		}
		int opcao;
		do {
			while (!scanner.hasNextInt()) {
				System.out.println("Por favor, digite um número inteiro válido.");
				scanner.next();
			}
			opcao = scanner.nextInt();
		} while (opcao <= 0 || opcao > filmes.size());
		Filme filmeEscolhido = filmes.get(opcao - 1);

		System.out.println("Digite sua avaliação para o filme (0 a 10):");
		double avaliacao = scanner.nextDouble();

		filmeService.avaliarFilme(filmeEscolhido.getIdentificador(), avaliacao);
	}

	private void filmesMaisAvaliados() {
		System.out.println("Filmes mais avaliados:");
		List<Filme> filmes = filmeService.listarFilmesMaisAvaliados();
		for (int i = 0; i < filmes.size(); i++) {
			Filme filme = filmes.get(i);
			double media = filme.getAvaliacoes().stream().mapToDouble(Double::doubleValue).average().orElse(0);
			System.out.println((i + 1) + " - " + filme.getNome() + " (" + media + ")");
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
				System.out.println("Deseja escolher(E) um ator da lista ou cadastrar(C) um novo? (E/C)");
				String escolha = scanner.next();
				if (escolha.equalsIgnoreCase("E")) {
					escolherAtor();
				} else {
					cadastrarAtor();
				}
			} else {
				cadastrarAtor = false;
			}
		}

		boolean cadastrarDiretor = true;
		while (cadastrarDiretor) {
			System.out.println("Deseja cadastrar um diretor para este filme? (S/N)");
			String resposta = scanner.next();
			if (resposta.equalsIgnoreCase("S")) {
				System.out.println("Deseja escolher(E) um diretor da lista ou cadastrar(C) um novo? (E/C)");
				String escolha = scanner.next();
				if (escolha.equalsIgnoreCase("E")) {
					escolherDiretor();
				} else {
					cadastrarDiretor();
				}
			} else {
				cadastrarDiretor = false;
			}
		}

		List<Filme> filmes = new ArrayList<>();
		filmes.add(filme);
		catalogoFilmeService.adicionarCatalogoFilme(filmes);
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

	public List<Filme> listarFilmesMaisAvaliados() {
		return filmeRepository.listarFilmes().stream()
				.sorted(Comparator.comparingDouble(this::calcularMediaAvaliacoes).reversed()).limit(10)
				.collect(Collectors.toList());
	}

	private double calcularMediaAvaliacoes(Filme filme) {
		return filme.getAvaliacoes().stream().mapToDouble(Double::doubleValue).average().orElse(0);
	}

	private void escolherAtor() {
		System.out.println("Escolha um ator:");
		List<Ator> atores = atorService.listarAtores();
		for (int i = 0; i < atores.size(); i++) {
			System.out.println((i + 1) + " - " + atores.get(i).getNome());
		}
		int opcao = scanner.nextInt();
		Ator atorEscolhido = atores.get(opcao - 1);
		System.out.println("Ator escolhido: " + atorEscolhido.getNome());
	}

	private void escolherDiretor() {
		System.out.println("Escolha um diretor:");
		List<Diretor> diretores = diretorService.listarDiretores();
		for (int i = 0; i < diretores.size(); i++) {
			System.out.println((i + 1) + " - " + diretores.get(i).getNome());
		}
		int opcao = scanner.nextInt();
		Diretor diretorEscolhido = diretores.get(opcao - 1);
		System.out.println("Diretor escolhido: " + diretorEscolhido.getNome());
	}
	
	private void listarFilmes() {
	    System.out.println("Lista de filmes cadastrados:");
	    List<Filme> filmes = catalogoFilmeService.listarFilmes();
	    for (int i = 0; i < filmes.size(); i++) {
	        System.out.println((i + 1) + " - " + filmes.get(i).getNome());
	    }
	}
}
