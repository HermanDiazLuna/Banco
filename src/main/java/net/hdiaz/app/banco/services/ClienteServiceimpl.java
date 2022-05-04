package net.hdiaz.app.banco.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.hdiaz.app.banco.models.Cliente;
import net.hdiaz.app.banco.repository.ClienteRepository;

@Service
public class ClienteServiceimpl implements IClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> buscarTodos() {
		List<Cliente> listasClientes = repository.findAll();
		return listasClientes;
		
	}

	@Override
	@Transactional
	public Cliente guardar(Cliente cliente) {
		return repository.save(cliente);

	}

	@Override
	@Transactional
	public void eliminar(Integer idCliente) {
		repository.deleteById(idCliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarPorId(Integer idCliente) {
		Cliente cliente = null;
		Optional<Cliente> op = repository.findById(idCliente);
		
		if (op.isPresent()) {
			return cliente = op.get();
		}
		
		return cliente;
		
	}

	@Override
	@Transactional
	public Cliente actualizar(Cliente cliente) {
		return repository.save(cliente);

	}

}
