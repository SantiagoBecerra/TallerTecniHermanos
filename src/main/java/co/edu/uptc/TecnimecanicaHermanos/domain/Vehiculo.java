package co.edu.uptc.TecnimecanicaHermanos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos" , schema = "taller_tecni_hermanos")
public class Vehiculo {


	@Id
	@Column(name="placa")
	String placa;


	@Column(name="modelo")
	String modelo;

	@Column(name="marca")
	String marca;

	@Column(name="color")
	String color;

	@Column(name="anio")
	String anio;

	@Column(name="descripcion")
	String descripcion;

	@ManyToOne
	@JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Personas personas;


	public Vehiculo(String placa, String modelo, String marca, String color, String anio, String descripcion,
			Personas persona) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.anio = anio;
		this.descripcion = descripcion;
		this.personas = persona;
	}


	public Vehiculo() {
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getAnio() {
		return anio;
	}



	public void setAnio(String anio) {
		this.anio = anio;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Personas getPersonas() {
		return personas;
	}
	
	public void setPersonas(Personas personas) {
		this.personas = personas;
	}

	


}
