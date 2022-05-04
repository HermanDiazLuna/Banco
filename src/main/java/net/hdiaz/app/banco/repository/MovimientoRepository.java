package net.hdiaz.app.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.hdiaz.app.banco.models.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

}
