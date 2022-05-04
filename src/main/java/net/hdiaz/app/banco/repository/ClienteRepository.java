package net.hdiaz.app.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.hdiaz.app.banco.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
