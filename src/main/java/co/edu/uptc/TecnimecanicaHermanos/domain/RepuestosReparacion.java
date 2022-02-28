package co.edu.uptc.TecnimecanicaHermanos.domain;

import javax.persistence.*;

@Entity
@Table(name = "repuestos_reparacion" , schema = "taller_tecni_hermanoss")
public class RepuestosReparacion {


	@Id
	@GeneratedValue
	@Column(name="cantidad_repuesto")
	Integer cantidad;


	@ManyToOne
	@JoinColumn(name = "id_repuesto", referencedColumnName = "id_repuesto")
	private Repuestos id_repuesto;

	@ManyToOne
	@JoinColumn(name = "id_reparacion", referencedColumnName = "id_reparacion")
	private Reparacion id_reparacion;

	public RepuestosReparacion(Integer cantidad) {
		this.cantidad = cantidad;
		this.id_repuesto = id_repuesto;
		this.id_reparacion = id_reparacion;
	}

	public RepuestosReparacion() {

	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Repuestos getId_repuesto() {
		return id_repuesto;
	}

	public void setId_repuesto(Repuestos id_repuesto) {
		this.id_repuesto = id_repuesto;
	}


	public Reparacion getId_reparacion() {
		return id_reparacion;
	}


	public void setId_reparacion(Reparacion id_reparacion) {
		this.id_reparacion = id_reparacion;
	}


}
