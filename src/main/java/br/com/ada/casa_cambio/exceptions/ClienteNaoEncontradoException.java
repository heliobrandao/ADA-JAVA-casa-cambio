package br.com.ada.casa_cambio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(String cpf) {
        super("Cliente não encontrado");
    }

    
}
