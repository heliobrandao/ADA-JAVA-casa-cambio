package br.com.ada.casa_cambio.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(String cpf) {
        super("Cliente não encontrado");
    }
}
