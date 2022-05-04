package net.hdiaz.app.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.hdiaz.app.banco.models.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
	
	@Modifying
	@Query("update Cuenta c set c.saldo = ?1 where c.id = ?2")
	public void actualizarSaldoCuenta(Double saldo, Integer id);
		
	
}
