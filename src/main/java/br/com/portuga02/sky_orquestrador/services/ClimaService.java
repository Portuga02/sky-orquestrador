package br.com.portuga02.sky_orquestrador.services;

import br.com.portuga02.sky_orquestrador.dtos.ClimaDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ClimaService {

	private final RestClient restClient = RestClient.create();

	// 1. O NOME da regra e qual método chamar se der BO (fallbackMethod)
	@CircuitBreaker(name = "openMeteoAPI", fallbackMethod = "planoDeEmergencia")
	public ClimaDTO buscarClimaAtual() {

		// VAMOS FORÇAR UM ERRO: Eu baguncei a URL de propósito colocando "API-QUEBRADA"
		String url = "https://api.open-meteo.com/v1/forecast?latitude=-8.05&longitude=-34.88&current_weather=true";

		JsonNode respostaApiExterna = restClient.get().uri(url).retrieve().body(JsonNode.class);

		Double temperaturaReal = respostaApiExterna.path("current_weather").path("temperature").asDouble();

		return new ClimaDTO("Recife", temperaturaReal, "Dados em tempo real via Open-Meteo", 0.0);
	}

	// 2. O MÉTODO DE FALLBACK (PLANO B)
	// Ele OBRIGATORIAMENTE precisa receber os mesmos parâmetros do método original
	// + a Exception (O Erro)
	public ClimaDTO planoDeEmergencia(Exception erro) {
		System.out.println("ALERTA: A API principal caiu! Acionando o Plano B... Motivo: " + erro.getMessage());

		// Em um sistema real, aqui você buscaria de um banco de dados local (Cache)
		// ou de uma segunda API (como a HG Brasil). Para o teste, vamos retornar um
		// dado padrão.
		return new ClimaDTO("Recife", 25.0, "API Indisponível - Retornando dados de Cache/Emergência", 0.0);
	}
}