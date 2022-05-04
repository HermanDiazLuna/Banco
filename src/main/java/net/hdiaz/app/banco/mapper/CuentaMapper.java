package net.hdiaz.app.banco.mapper;

import java.util.ArrayList;
import java.util.List;


import net.hdiaz.app.banco.dto.CuentaDto;
import net.hdiaz.app.banco.models.Cliente;
import net.hdiaz.app.banco.models.Cuenta;

public class CuentaMapper {
	
	public static Cuenta toEntity(CuentaDto cuentaDto) {
		
		Cuenta cuenta = new Cuenta();
		cuenta.setId(cuentaDto.getId());
		cuenta.setNumero(cuentaDto.getNumero());
		cuenta.setSaldo(cuentaDto.getSaldo());
		
		Cliente cliente = new Cliente();
		cliente.setId(cuentaDto.getIdCliente());
		
		cuenta.setCliente(cliente);
		
		return cuenta;
	}
	
	public static CuentaDto toCuentaDto(Cuenta cuenta) {
		
		CuentaDto cuentaDto = new CuentaDto();
		cuentaDto.setId(cuenta.getId());
		cuentaDto.setNumero(cuenta.getNumero());
		cuentaDto.setSaldo(cuenta.getSaldo());
		cuentaDto.setIdCliente(cuenta.getCliente().getId());
		
		
		return cuentaDto;
	}
	
	public static List<CuentaDto> toListaDto(List<Cuenta> listaCuenta){
		
		List<CuentaDto> listaDto = new ArrayList<>();
		
		for(Cuenta cuenta: listaCuenta) {
			CuentaDto cuentaDto = new CuentaDto();
			cuentaDto.setId(cuenta.getId());
			cuentaDto.setNumero(cuenta.getNumero());
			cuentaDto.setSaldo(cuenta.getSaldo());
			cuentaDto.setIdCliente(cuenta.getCliente().getId());
			
			listaDto.add(cuentaDto);
		}
		return listaDto;
		
	}
}
