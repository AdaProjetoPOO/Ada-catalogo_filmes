package br.com.ada.catalogoFilmes.entity;

import br.com.ada.catalogoFilmes.enuns.Sexo;

public class Pessoa {
	
	private String nome;
	private Integer idade;
	private Sexo sexo;

	public Pessoa(String nome, Integer idade, Sexo sexo) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}

}
