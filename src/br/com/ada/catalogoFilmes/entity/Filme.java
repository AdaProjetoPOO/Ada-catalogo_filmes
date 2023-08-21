package br.com.ada.catalogoFilmes.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filme {

	private static Integer ultimoIdentificador = 0;
	private Integer identificador;
	private String nome;
	private String dtLancamento;
	private Double orcamento;
	private String descricao;
	private Diretor diretor;
	private List<Ator> atores;
	 private List<Double> avaliacoes;
	
	public Filme() {}

	public Filme(String nome, String dataLancamento, double orcamento, String descricao) {
		this.identificador = ++ultimoIdentificador;
		this.nome = nome;
		this.dtLancamento = dataLancamento;
		this.orcamento = orcamento;
		this.descricao = descricao;
		this.atores = new ArrayList<>();
		 this.avaliacoes = new ArrayList<>();
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtLancamento() {
		return dtLancamento;
	}

	public void setDtLancamento(String dtLancamento) {
		this.dtLancamento = dtLancamento;
	}

	public Double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	public List<Double> getAvaliacoes() {
        return avaliacoes;
    }

	@Override
	public int hashCode() {
		return Objects.hash(atores, descricao, diretor, dtLancamento, identificador, nome, orcamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(atores, other.atores) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(diretor, other.diretor) && Objects.equals(dtLancamento, other.dtLancamento)
				&& Objects.equals(identificador, other.identificador) && Objects.equals(nome, other.nome)
				&& Objects.equals(orcamento, other.orcamento);
	}

	@Override
	public String toString() {
		return "Filme [identificador=" + identificador + ", nome=" + nome + ", dtLancamento=" + dtLancamento
				+ ", orcamento=" + orcamento + ", descricao=" + descricao + ", diretor=" + diretor + ", atores="
				+ atores + "]";
	}	
}
