package br.com.portuga02.sky_orquestrador.controllers;

import br.com.portuga02.sky_orquestrador.dtos.ClimaDTO;
import br.com.portuga02.sky_orquestrador.services.ClimaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimaController {

    // 1. Declaramos o Service
    private final ClimaService climaService;

    // 2. Injeção de Dependência via Construtor
    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping("/api/clima")
    public ClimaDTO statusClima() {
        // 3. O Controller agora só repassa a bola para o Service
        return climaService.buscarClimaAtual();
    }
}