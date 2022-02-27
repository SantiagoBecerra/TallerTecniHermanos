package co.edu.uptc.TecnimecanicaHermanos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "repuestos_reparacion" , schema = "taller_tecni_hermanos")
public class RepuestosReparacion {


	@Id
	@GeneratedValue
	@Column(name="cantidad")
	Integer cantidad;

	@Column(name="id_repuesto")
	Integer id_repuesto;
	
	@Column(name="id_reparacion")
	Integer id_reparacion;
	

	public RepuestosReparacion(Integer cantidad, Integer id_repuesto, Integer id_reparacion) {
		super();
		this.cantidad = cantidad;
		this.id_repuesto = id_repuesto;
		this.id_reparacion = id_reparacion;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Integer getId_repuesto() {
		return id_repuesto;
	}


	public void setId_repuesto(Integer id_repuesto) {
		this.id_repuesto = id_repuesto;
	}


	public Integer getId_reparacion() {
		return id_reparacion;
	}


	public void setId_reparacion(Integer id_reparacion) {
		this.id_reparacion = id_reparacion;
	}

	
}
