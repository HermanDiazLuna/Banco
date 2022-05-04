package net.hdiaz.app.banco.services;

import java.util.List;
import net.hdiaz.app.banco.models.Cuenta;


public interface ICuentaService {
	
	List<Cuenta> buscarTodos();
	Cuenta guardar(Cuenta cuenta);
	Cuenta buscarPorId(Integer idCuenta);
	
}
