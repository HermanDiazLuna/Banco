package net.hdiaz.app.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.hdiaz.app.banco.dto.CuentaDto;
import net.hdiaz.app.banco.mapper.CuentaMapper;
import net.hdiaz.app.banco.models.Cuenta;
import net.hdiaz.app.banco.services.ICuentaService;



@RestController
@RequestMapping("/api")
public class CuentaController {

	@Autowired
	private ICuentaService service;
	
	@PostMapping("/guardar-cuenta")
	public ResponseEntity<?> guardar(@RequestBody CuentaDto cuentaDto){
		Cuenta cta = service.guardar(CuentaMapper.toEntity(cuentaDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(CuentaMapper.toCuentaDto(cta));
		
	}
	
	@GetMapping("buscar-cuentas")
	public ResponseEntity<?> buscarTodas(){
		
		List<Cuenta> listaCuenta = service.buscarTodos();
		List<CuentaDto> listaDto = CuentaMapper.toListaDto(listaCuenta);
		return ResponseEntity.status(HttpStatus.OK).body(listaDto);
	}
	
	@GetMapping("buscar-cuenta/{id}")
		public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id){
			
			Cuenta cuenta = service.buscarPorId(id);
			CuentaDto cuentaDto = CuentaMapper.toCuentaDto(cuenta);
			return ResponseEntity.status(HttpStatus.OK).body(cuentaDto);
	}
}
