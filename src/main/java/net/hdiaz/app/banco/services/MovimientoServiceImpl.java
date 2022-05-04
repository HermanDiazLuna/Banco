package net.hdiaz.app.banco.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.hdiaz.app.banco.exceptions.BancoExceptions;
import net.hdiaz.app.banco.models.Cuenta;
import net.hdiaz.app.banco.models.Movimiento;
import net.hdiaz.app.banco.repository.CuentaRepository;
import net.hdiaz.app.banco.repository.MovimientoRepository;

@Service
public class MovimientoServiceImpl implements IMovimientoService {
	
	@Autowired
	private MovimientoRepository repository;
	
	@Autowired
	private CuentaRepository repoCuenta;
	
	@Override
	@Transactional
	public Movimiento guardarMovimiento(Movimiento movimiento) {
		Optional<Cuenta> cuentaOrigen = repoCuenta.findById(movimiento.getCuentaOrigen().getId());
		if(!cuentaOrigen.isPresent()) {
			throw new BancoExceptions("La cuenta origen no existe");
		}
		Optional<Cuenta> cuentaDestino = repoCuenta.findById(movimiento.getCuentaDestino().getId());
		if (!cuentaDestino.isPresent()) {
			throw new BancoExceptions("La cuenta destino no existe");
		}
		if (movimiento.getValor() <= 0) {
			throw new BancoExceptions("Digite el valor a transferir que sea mayor de cero");
		}
		if (cuentaOrigen.get().getSaldo() < movimiento.getValor()) {
			throw new BancoExceptions("Saldo insuficiente");
		}
		
		Double nuevoSaldoCuentaOrigen = cuentaOrigen.get().getSaldo() - movimiento.getValor();
		repoCuenta.actualizarSaldoCuenta(nuevoSaldoCuentaOrigen, cuentaOrigen.get().getId());
		
		Double nuevoSaldoCuentaDestino = cuentaDestino.get().getSaldo() + movimiento.getValor();
		repoCuenta.actualizarSaldoCuenta(nuevoSaldoCuentaDestino, cuentaDestino.get().getId());
		
		
		return repository.save(movimiento);
		 
	}

}
