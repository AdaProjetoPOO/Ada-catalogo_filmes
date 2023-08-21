package br.com.ada.catalogoFilmes.entity;

import br.com.ada.catalogoFilmes.enuns.Sexo;

@SuppressWarnings("unused")
public abstract class Pessoa {
	
	private String nome;
	private Integer idade;
	private Sexo sexo;

	public Pessoa(String nome, Integer idade, Sexo sexo) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public String getNome() {
	    return nome;
	}
}
