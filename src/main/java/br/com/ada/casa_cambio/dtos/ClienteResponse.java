
package br.com.ada.casa_cambio.dtos;


import br.com.ada.casa_cambio.entidades.Cliente;

import java.time.LocalDate;

public record ClienteResponse(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String sexo,
        String estadoCivil
) {

    public static ClienteResponse de(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataNascimento(),
                cliente.getSexo(),
                cliente.getEstadoCivil()
        );
    }
}