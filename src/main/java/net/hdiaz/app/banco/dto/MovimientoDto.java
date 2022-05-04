package net.hdiaz.app.banco.dto;

import java.util.Date;

public class MovimientoDto {
	private Integer id;
	private Date fecha;
	private Double valor;
	private Integer cuentaOrigen;
	private Integer cuentaDestino;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getCuentaOrigen() {
		return cuentaOrigen;
	}
	public void setCuentaOrigen(Integer cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	public Integer getCuentaDestino() {
		return cuentaDestino;
	}
	public void setCuentaDestino(Integer cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
}
