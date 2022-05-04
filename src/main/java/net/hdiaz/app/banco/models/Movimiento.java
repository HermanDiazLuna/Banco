package net.hdiaz.app.banco.models;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimiento {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private Date fecha;
		private Double valor;
		
		@ManyToOne
		@JoinColumn(name = "cuenta_origen")
		private Cuenta cuentaOrigen;
		
		@ManyToOne
		@JoinColumn(name = "cuenta_destino")
		private Cuenta cuentaDestino;
		
		
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
		public Cuenta getCuentaOrigen() {
			return cuentaOrigen;
		}
		public void setCuentaOrigen(Cuenta cuentaOrigen) {
			this.cuentaOrigen = cuentaOrigen;
		}
		public Cuenta getCuentaDestino() {
			return cuentaDestino;
		}
		public void setCuentaDestino(Cuenta cuentaDestino) {
			this.cuentaDestino = cuentaDestino;
		}
		
		
}
