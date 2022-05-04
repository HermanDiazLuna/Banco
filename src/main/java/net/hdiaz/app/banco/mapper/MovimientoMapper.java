package net.hdiaz.app.banco.mapper;

import net.hdiaz.app.banco.dto.MovimientoDto;
import net.hdiaz.app.banco.exceptions.BancoExceptions;
import net.hdiaz.app.banco.models.Cuenta;
import net.hdiaz.app.banco.models.Movimiento;

public class MovimientoMapper {
	
	public static Movimiento toEntity(MovimientoDto movimientoDto) {
		
		Movimiento movimiento = new Movimiento();
		
		movimiento.setId(movimientoDto.getId());
		movimiento.setFecha(movimientoDto.getFecha());
		if (movimientoDto.getValor() == null) {
			throw new BancoExceptions("Digite algun valor");
		}
		movimiento.setValor(movimientoDto.getValor());
		
		Cuenta cuentaOrigen = new Cuenta();
		cuentaOrigen.setId(movimientoDto.getCuentaOrigen());
		
		movimiento.setCuentaOrigen(cuentaOrigen);
		
		Cuenta cuentaDestino = new Cuenta();
		cuentaDestino.setId(movimientoDto.getCuentaDestino());
		
		movimiento.setCuentaDestino(cuentaDestino);
		
		return movimiento;
	}
	
	public static MovimientoDto toDto(Movimiento movimiento) {
		
		MovimientoDto movimientoDto = new MovimientoDto();
		
		movimientoDto.setId(movimiento.getId());
		movimientoDto.setFecha(movimiento.getFecha());
		movimientoDto.setValor(movimiento.getValor());
		movimientoDto.setCuentaOrigen(movimiento.getCuentaOrigen().getId());
		movimientoDto.setCuentaDestino(movimiento.getCuentaDestino().getId());
		
		return movimientoDto;
	}
	
}
