package br.com.ada.casa_cambio.controllers;

import br.com.ada.casa_cambio.services.ClienteService;
import br.com.ada.casa_cambio.dtos.ClienteResponse;
import br.com.ada.casa_cambio.dtos.ClienteRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/clientes")
class ClienteController {

    private final ClienteService service;

    ClienteController(ClienteService service) { 
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)                       // 201
    ClienteResponse cadastrar(@RequestBody @Valid ClienteRequest req) {
        return ClienteResponse.de(service.cadastrar(req.paraDominio()));
    }

    @GetMapping("/{cpf}")
    ClienteResponse porCpf(@PathVariable String cpf) {        // 200 ou 404
        return ClienteResponse.de(service.buscarPorCpf(cpf));
    }
}