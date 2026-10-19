package br.com.ada.casa_cambio.repositorios;

import br.com.ada.casa_cambio.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);
}