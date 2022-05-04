package net.hdiaz.app.banco.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.hdiaz.app.banco.dto.ClienteDto;
import net.hdiaz.app.banco.mapper.ClienteMapper;
import net.hdiaz.app.banco.models.Cliente;
import net.hdiaz.app.banco.services.IClienteService;

@CrossOrigin({"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	
	@GetMapping("/clientes")
	public ResponseEntity<?> buscarTodos(){
		List<Cliente> listaCliente = service.buscarTodos();
		List<ClienteDto> listaClienteDto = ClienteMapper.toListDto(listaCliente);
		return ResponseEntity.ok().body(listaClienteDto);
	}
	
	@PostMapping("/guardar-cliente")
	public ResponseEntity<?> guardar(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = ClienteMapper.toEntity(clienteDto);
		
		Cliente c = service.guardar(cliente);
		ClienteDto dto = ClienteMapper.toClienteDto(c);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@DeleteMapping("/eliminar-cliente/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Integer idCliente) {
		service.eliminar(idCliente);
		String regElim = "Registro eliminado";
		return ResponseEntity.status(HttpStatus.OK).body(regElim);
		
	}
	@GetMapping("/buscar-cliente/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer idCliente) {
		
		Cliente cliente = service.buscarPorId(idCliente);
		return ResponseEntity.ok(ClienteMapper.toClienteDto(cliente));
	}
	
	@PutMapping("/actualizar-cliente")
	public ResponseEntity<?> actualizar(@RequestBody ClienteDto clienteDto) {
		Cliente actCliente = service.actualizar(ClienteMapper.toEntity(clienteDto));
		return ResponseEntity.status(HttpStatus.OK).body(actCliente);
		
	}
	
}
