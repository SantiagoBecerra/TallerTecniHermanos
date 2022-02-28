package co.edu.uptc.TecnimecanicaHermanos.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "repuestos" , schema = "taller_tecni_hermanos")
public class Repuestos {


	@Id
	@GeneratedValue
	@Column(name="id_repuesto")
	Integer id_repuesto;

	@Column(name="nombre_repuesto")
	String nombre_repuesto;
	
	@Column(name="costo_unitario")
	Integer costo_unitario;
	
	@Column(name="cantidad_inventario")
	Integer cantidad_inventario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_repuesto")
	private List<RepuestosReparacion> repuestosReparaciones;

	public Repuestos(Integer id_repuesto, String nombre_repuesto, Integer costo_unitario, Integer cantidad_inventario) {
		super();
		this.id_repuesto = id_repuesto;
		this.nombre_repuesto = nombre_repuesto;
		this.costo_unitario = costo_unitario;
		this.cantidad_inventario = cantidad_inventario;
	}

	public Repuestos() {
	}

	public Integer getId_repuesto() {
		return id_repuesto;
	}
	public void setId_repuesto(Integer id_repuesto) {
		this.id_repuesto = id_repuesto;
	}
	public String getNombre_repuesto() {
		return nombre_repuesto;
	}
	
	public void setNombre_repuesto(String nombre_repuesto) {
		this.nombre_repuesto = nombre_repuesto;
	}

	public Integer getCosto_unitario() {
		return costo_unitario;
	}

	public void setCosto_unitario(Integer costo_unitario) {
		this.costo_unitario = costo_unitario;
	}

	public Integer getCantidad_inventario() {
		return cantidad_inventario;
	}

	public void setCantidad_inventario(Integer cantidad_inventario) {
		this.cantidad_inventario = cantidad_inventario;
	}

	public List<RepuestosReparacion> getRepuestosReparaciones() {
		return repuestosReparaciones;
	}

	public void setRepuestosReparaciones(List<RepuestosReparacion> repuestosReparaciones) {
		this.repuestosReparaciones = repuestosReparaciones;
	}
}
