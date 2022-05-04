package net.hdiaz.app.banco.services;

import java.util.List;
import net.hdiaz.app.banco.models.Cliente;

public interface IClienteService {
	
	List<Cliente> buscarTodos();
	Cliente guardar(Cliente cliente);
	void eliminar(Integer idCliente);
	Cliente buscarPorId(Integer idCliente);
	Cliente actualizar(Cliente cliente);
	
}
