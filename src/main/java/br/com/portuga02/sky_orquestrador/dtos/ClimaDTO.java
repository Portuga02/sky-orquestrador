package br.com.portuga02.sky_orquestrador.dtos;

public class ClimaDTO {

	// 1. Os atributos são privados (encapsulamento)
	private String cidade;
	private Double temperaturaAtual;
	private String descricao;
	private Double milimetrosChuva;

	// 2. O Construtor (para preenchermos os dados facilmente)
	public ClimaDTO(String cidade, Double temperaturaAtual, String descricao, Double milimetrosChuva) {
		this.cidade = cidade;
		this.temperaturaAtual = temperaturaAtual;
		this.descricao = descricao;
		this.milimetrosChuva = milimetrosChuva;
	}

	// 3. Os Getters (EXTREMAMENTE IMPORTANTES)
	// O Spring Boot usa esses métodos "get" para conseguir ler os dados e montar o
	// JSON.
	public String getCidade() {
		return cidade;
	}

	public Double getTemperaturaAtual() {
		return temperaturaAtual;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getMilimetrosChuva() {
		return milimetrosChuva;
	}
}