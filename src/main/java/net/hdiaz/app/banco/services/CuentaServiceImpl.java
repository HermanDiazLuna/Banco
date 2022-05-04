package net.hdiaz.app.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.hdiaz.app.banco.models.Cuenta;
import net.hdiaz.app.banco.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	private CuentaRepository repository;
	
	@Override
	public List<Cuenta> buscarTodos() {
		List<Cuenta> listaCuentas = repository.findAll();
		return listaCuentas;
	}

	@Override
	public Cuenta guardar(Cuenta cuenta) {
		return repository.save(cuenta);
	}

	@Override
	public Cuenta buscarPorId(Integer idCuenta) {
		
		Cuenta cuenta = null;
		Optional<Cuenta> op = repository.findById(idCuenta);
		
		if (op.isPresent()) {
			return cuenta = op.get();
		}
		
		return cuenta;
		
	}

}
