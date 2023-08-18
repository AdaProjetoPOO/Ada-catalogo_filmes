package br.com.ada.catalogoFilmes.enuns;

public enum Sexo {

	M("Masculino"), 
	F("Feminino"), 
	N("Neutro");

	final private String nome;

	Sexo(String nome) {
	        this.nome = nome;
	    }

	public String getNome() {
		return nome;
	}
}
