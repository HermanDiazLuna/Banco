package net.hdiaz.app.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.hdiaz.app.banco.dto.MovimientoDto;
import net.hdiaz.app.banco.mapper.MovimientoMapper;
import net.hdiaz.app.banco.models.Movimiento;
import net.hdiaz.app.banco.services.IMovimientoService;

@RestController
@RequestMapping("/api")
public class MovimientoController {
	
	@Autowired
	private IMovimientoService service;
	
	@PostMapping("/guardar-movimiento")
	public ResponseEntity<?> guardarMovimiento(@RequestBody MovimientoDto movimientoDto){
		System.out.println("valor ----> "+ movimientoDto.getValor());
		Movimiento movimiento = service.guardarMovimiento(MovimientoMapper.toEntity(movimientoDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(MovimientoMapper.toDto(movimiento));
		
	}
}
