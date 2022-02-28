/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.uptc.TecnimecanicaHermanos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import co.edu.uptc.TecnimecanicaHermanos.domain.OrdenReparacion;
import co.edu.uptc.TecnimecanicaHermanos.domain.Personas;
import co.edu.uptc.TecnimecanicaHermanos.domain.Servicios;
import co.edu.uptc.TecnimecanicaHermanos.domain.Vehiculo;


public interface GeneralRepositoryOrdenReparacion extends JpaRepository<OrdenReparacion, Integer>{
	
    
    @Query(value= "SELECT * FROM orden_reparaciones ORDER BY id_orden",nativeQuery = true)
    public List<OrdenReparacion> getOrdenesReparaciones();
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value= " INSERT INTO orden_reparaciones (diagnostico,Fecha_orden,id_empleado,placa) VALUES(?,?,?,?)",nativeQuery = true)
    public void registrarOrdenReparacion(String diagnostico,String Fecha_orden,int empleado,String placa);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "DELETE FROM orden_reparaciones WHERE id_orden = ?",nativeQuery = true)
	public void eliminarOrdenReparacion(String idOrden);

    @Query(value= "SELECT * FROM orden_reparaciones WHERE id_orden = ?1 ",nativeQuery = true)
	public OrdenReparacion getOrdenReparacionById(String id);

    @Query(value= "SELECT * FROM orden_reparaciones WHERE id_orden = ?1 ",nativeQuery = true)
    public OrdenReparacion getOrdenReparacionByIdOrden(int id);

    @Query(value= "SELECT * FROM orden_reparaciones WHERE placa = ?1 ",nativeQuery = true)
   	public List<OrdenReparacion> getOrdenReparacionByPlaca(String id);

    @Query(value= "SELECT * FROM orden_reparaciones WHERE id_empleado = ?1 ",nativeQuery = true)
    public List<OrdenReparacion> getOrdenReparacionByIdEmpleado(int id);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
	@Query(value = "UPDATE orden_reparaciones SET diagnostico= ?2 WHERE id_orden = ?1",nativeQuery = true)
	public void actualizarOrdenReparacion(int idOrden, String diagnostico);
    
}








