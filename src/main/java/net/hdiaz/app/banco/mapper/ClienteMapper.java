package net.hdiaz.app.banco.mapper;

import java.util.ArrayList;
import java.util.List;

import net.hdiaz.app.banco.dto.ClienteDto;
import net.hdiaz.app.banco.models.Cliente;

public class ClienteMapper {
	
	public static Cliente toEntity(ClienteDto clienteDto) {
		
		Cliente cliente = new Cliente();
		
		cliente.setId(clienteDto.getId());
		cliente.setNombre(clienteDto.getNombre());
		cliente.setDireccion(clienteDto.getDireccion());
		cliente.setTelefono(clienteDto.getTelefono());
		
		return cliente;
	}
	
	public static ClienteDto toClienteDto(Cliente cliente) {
		
		ClienteDto clienteDto = new ClienteDto();
		
		clienteDto.setId(cliente.getId());
		clienteDto.setNombre(cliente.getNombre());
		clienteDto.setDireccion(cliente.getDireccion());
		clienteDto.setTelefono(cliente.getTelefono());
		
		return clienteDto;
		
	}
	
	public static List<ClienteDto> toListDto(List<Cliente> listaCliente){
		
		List<ClienteDto> listaClienteDto = new ArrayList<>();
		
		for(Cliente cliente: listaCliente) {
			ClienteDto clienteDto = new ClienteDto();
			clienteDto.setId(cliente.getId());
			clienteDto.setNombre(cliente.getNombre());
			clienteDto.setDireccion(cliente.getDireccion());
			clienteDto.setTelefono(cliente.getTelefono());
			
			listaClienteDto.add(clienteDto);
		}
		return listaClienteDto;
	}
}
