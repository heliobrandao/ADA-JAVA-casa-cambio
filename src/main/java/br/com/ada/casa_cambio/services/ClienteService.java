package br.com.ada.casa_cambio.services;

import org.springframework.stereotype.Service;
import br.com.ada.casa_cambio.entidades.Cliente;
import br.com.ada.casa_cambio.exceptions.ClienteNaoEncontradoException;
import br.com.ada.casa_cambio.repositorios.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Cliente cadastrar(Cliente cliente) {
        return repository.save(cliente);
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new ClienteNaoEncontradoException(cpf));
    }
}

