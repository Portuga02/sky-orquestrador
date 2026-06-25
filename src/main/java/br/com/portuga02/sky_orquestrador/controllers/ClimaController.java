package br.com.portuga02.sky_orquestrador.controllers;

import br.com.portuga02.sky_orquestrador.dtos.ClimaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimaController {

    @GetMapping("/api/clima")
    public ClimaDTO statusClima() {
        // Por enquanto, vamos "mockar" (chumbar) os dados de Recife. 
        // Em breve, isso virá da API externa.
        return new ClimaDTO("Recife", 28.5, "Parcialmente Nublado", 12.0);
    }
}