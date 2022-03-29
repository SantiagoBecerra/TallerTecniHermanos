package co.edu.uptc.TecnimecanicaHermanos.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personas" , schema = "taller_tecni_hermanos")
public class Personas {

	@Id
	@GeneratedValue
	@Column(name="id_persona")
	Integer id_persona;

	@Column(name="nombres")
	String nombres;
	
	@Column(name="apellidos")
	String apellidos;
	
	@Column(name="documento")
	String documento;
	
	@Column(name="direccion")
	String direccion;
	
	@Column(name="telefono")
	String telefono;
	
	@Column(name="tipo_persona")
	Character tipo_persona;
	
	@Column(name="tipo_empleado")
	Character tipo_empleado;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personas")
    private List<Vehiculo> vehiculos;
	


	public Personas(Integer id_persona, String nombres, String apellidos, String documento, String direccion,
			String telefono, char tipo_persona, char tipo_empleado) {
		super();
		this.id_persona = id_persona;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.documento = documento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipo_persona = tipo_persona;
		this.tipo_empleado = tipo_empleado;
	}
	
	public Personas(Integer id_persona, String nombres, String apellidos, String documento, String direccion,
			String telefono, char tipo_persona) {
		super();
		this.id_persona = id_persona;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.documento = documento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipo_persona = tipo_persona;
	}
	
	
	public Personas(Integer id_persona, String nombres, String apellidos, String documento, String direccion,
			String telefono, char tipo_persona, char tipo_empleado, String user, String pass) {
		super();
		this.id_persona = id_persona;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.documento = documento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipo_persona = tipo_persona;
		this.tipo_empleado = tipo_empleado;
	}

	public Personas() {
	}
	
	
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public char getTipo_persona() {
		return tipo_persona;
	}

	public void setTipo_persona(char tipo_persona) {
		this.tipo_persona = tipo_persona;
	}

	public char getTipo_empleado() {
		return tipo_empleado;
	}

	public void setTipo_empleado(char tipo_empleado) {
		this.tipo_empleado = tipo_empleado;
	}

}
