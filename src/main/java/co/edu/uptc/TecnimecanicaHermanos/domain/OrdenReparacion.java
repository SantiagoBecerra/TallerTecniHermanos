package co.edu.uptc.TecnimecanicaHermanos.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orden_reparaciones" , schema = "taller_tecni_hermanos")
public class OrdenReparacion {
	
	
	@Id
	@GeneratedValue
	@Column(name="id_orden")
	Integer id_orden;
	
	@Column(name="diagnostico")
	String diagnostico;
	
	@Column(name="fecha_orden")
	Date fecha_orden;
	
	@Column(name="costo_total")
	Integer costo_total;
	
	@OneToOne
	@JoinColumn(name = "id_empleado", referencedColumnName = "id_persona")
	Personas id_empleado;
	
	@ManyToOne
	@JoinColumn(name = "placa", referencedColumnName = "placa")
	Vehiculo placa;

	public OrdenReparacion() {
	}

	public OrdenReparacion(Integer id_orden, String diagnostico, Date fecha_orden, Integer costo_total,
			Personas id_empleado, Vehiculo placa) {
		super();
		this.id_orden = id_orden;
		this.diagnostico = diagnostico;
		this.fecha_orden = fecha_orden;
		this.costo_total = costo_total;
		this.id_empleado = id_empleado;
		this.placa = placa;
	}

	public Integer getId_orden() {
		return id_orden;
	}

	public void setId_orden(Integer id_orden) {
		this.id_orden = id_orden;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Date getFecha_orden() {
		return fecha_orden;
	}

	public void setFecha_orden(Date fecha_orden) {
		this.fecha_orden = fecha_orden;
	}

	public Integer getCosto_total() {
		return costo_total;
	}

	public void setCosto_total(Integer costo_total) {
		this.costo_total = costo_total;
	}

	public Personas getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Personas id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Vehiculo getPlaca() {
		return placa;
	}

	public void setPlaca(Vehiculo placa) {
		this.placa = placa;
	}
	
	
	
//	esta es una prueba
	
	//CHIUSSSJSJSJSJ
	
	// prueba 3 ajajajdfbsreberwhgh4wrhwtrhjjjwtrjtrj
	
	//prueba 5555ewfefffssssvvvvv adaksdlasdjlasjdklas
	
	//RAMA MASTER
	
}
