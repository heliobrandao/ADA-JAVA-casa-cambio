package br.com.ada.casa_cambio.dtos;

import br.com.ada.casa_cambio.entidades.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record ClienteRequest(
        @NotBlank(message = "O nome e obrigatorio")
        @Size(max = 255, message = "O nome deve ter no maximo 255 caracteres")
        String nome,

        @NotBlank(message = "O CPF e obrigatorio")
        @Pattern(
                regexp = "[0-9]{11}",
                message = "O CPF deve conter exatamente 11 digitos, sem pontuacao"
        )
        @CPF(message = "O CPF informado e invalido")
        String cpf,

        @Past(message = "A data de nascimento deve ser anterior a hoje")
        LocalDate dataNascimento,

        @Size(max = 255, message = "O sexo deve ter no maximo 255 caracteres")
        String sexo,

        @Size(max = 255, message = "O estado civil deve ter no maximo 255 caracteres")
        String estadoCivil
) {

    public Cliente paraDominio() {
        return new Cliente(
                nome,
                cpf,
                dataNascimento,
                sexo,
                estadoCivil
        );
    }
}