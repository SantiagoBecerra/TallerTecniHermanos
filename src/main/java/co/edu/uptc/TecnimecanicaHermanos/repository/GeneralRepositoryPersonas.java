/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.uptc.TecnimecanicaHermanos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import co.edu.uptc.TecnimecanicaHermanos.domain.Personas;


public interface GeneralRepositoryPersonas extends JpaRepository<Personas, Integer>{
	
//  ---------------------------    LOGIN    -----------------------------------
	
    @Query(value= "SELECT * FROM personas WHERE user LIKE %?1% AND pass LIKE %?2%",nativeQuery = true)
    public Personas getUsuarioLogin(String usuario,String contrasenia);
  
    
  //  -------------------------------Clientes---------------------------------------
    
    @Query(value= "SELECT * FROM personas WHERE TIPO_PERSONA LIKE 'C' ORDER BY apellidos",nativeQuery = true)
    public List<Personas> getClientes();
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value= " INSERT INTO personas(nombres, apellidos, documento ,direccion, telefono, tipo_persona) VALUES(?,?,?,?,?,?)",nativeQuery = true)
    public void registrarCliente(String nombres ,String apellidos,String documento,String direccion,String telefono,char tipo_persona);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "DELETE FROM personas WHERE documento=?",nativeQuery = true)
	public void eliminarCliente(String documento);
    
    @Query(value= "SELECT * FROM personas WHERE DOCUMENTO like ? AND TIPO_PERSONA LIKE 'C'",nativeQuery = true)
	public Personas getClienteById(String id);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
	@Query(value = "UPDATE personas SET nombres= ?2 , apellidos= ?3 , telefono= ?4, direccion= ?5 WHERE DOCUMENTO like ?1",nativeQuery = true)
	public void actualizarCliente(String documento,String nombres,String apellido, String telefono, String direccion);

    
    
//  ---------------------------Empleados-----------------------------------
     
    @Query(value= "SELECT * FROM personas WHERE TIPO_PERSONA LIKE 'E' ORDER BY apellidos",nativeQuery = true)
    public List<Personas> getEmpleados();
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value= " INSERT INTO personas(nombres, apellidos, documento ,direccion, telefono, tipo_persona, tipo_empleado) VALUES(?,?,?,?,?,?,?)",nativeQuery = true)
    public void registrarEmpleado(String nombres ,String apellidos,String documento,String direccion,String telefono,char tipoPersona, char tipoEmpleado);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "DELETE FROM personas WHERE documento=?",nativeQuery = true)
	public void eliminarEmpleado(String documento);
    
    @Query(value= "SELECT * FROM personas WHERE DOCUMENTO like ? AND TIPO_PERSONA LIKE 'E'",nativeQuery = true)
	public Personas getEmpleadoById(String id);
    
    @Query(value= "SELECT * FROM personas WHERE apellidos like ? AND TIPO_PERSONA LIKE 'E'",nativeQuery = true)
	public Personas getEmpleadoByLastName(String id);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
	@Query(value = "UPDATE personas SET nombres= ?2 , apellidos= ?3 , telefono= ?4, direccion= ?5 ,tipo_empleado= ?6 WHERE DOCUMENTO like ?1",nativeQuery = true)
	public void actualizarEmpleado(String documento,String nombres,String apellido, String telefono, String direccion, char tipoEmpleado);
    
}







