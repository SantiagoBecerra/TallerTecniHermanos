package co.edu.uptc.TecnimecanicaHermanos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicios" , schema = "taller_tecni_hermanos")
public class Servicios {


	@Id
	@GeneratedValue
	@Column(name="id_servicio")
	Integer id_servicio;

	@Column(name="nombre_servicio")
	String nombre_servicio;

	public Servicios(int idServicio, String nombreServicio) {
		super();
		this.id_servicio = idServicio;
		this.nombre_servicio = nombreServicio;
	}


	public Servicios() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId_servicio() {
		return id_servicio;
	}

	public String getNombre_servicio() {
		return nombre_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}

}
