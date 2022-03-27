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

    @Query(value= "SELECT costo_total FROM orden_reparaciones\n" +
            "WHERE id_orden = ?1 ",nativeQuery = true)
    public Integer getCostoTotal(int id);

    @Query(value= "SELECT p.nombres FROM orden_reparaciones op,vehiculos v,personas p\n" +
            "WHERE op.placa = v.placa\n" +
            "AND v.id_persona = p.id_persona\n" +
            "AND op.id_orden = ?1 ",nativeQuery = true)
    public String getOrdenNombres(int id_orden);

    @Query(value= "SELECT p.apellidos FROM orden_reparaciones op,vehiculos v,personas p\n" +
            "WHERE op.placa = v.placa\n" +
            "AND v.id_persona = p.id_persona\n" +
            "AND op.id_orden =?1",nativeQuery = true)
    public String getOrdenApellidos(int id_orden);

    @Query(value= "SELECT p.documento FROM orden_reparaciones op,vehiculos v,personas p\n" +
            "WHERE op.placa = v.placa\n" +
            "AND v.id_persona = p.id_persona\n" +
            "AND op.id_orden = ?1 ",nativeQuery = true)
    public String getOrdenDocumento(int id_orden);

    @Query(value= "SELECT p.direccion FROM orden_reparaciones op,vehiculos v,personas p\n" +
            "WHERE op.placa = v.placa\n" +
            "AND v.id_persona = p.id_persona\n" +
            "AND op.id_orden = ?1",nativeQuery = true)
    public String getOrdenDireccion(int id_orden);

    @Query(value= "SELECT p.telefono FROM orden_reparaciones op,vehiculos v,personas p\n" +
            "WHERE op.placa = v.placa\n" +
            "AND v.id_persona = p.id_persona\n" +
            "AND op.id_orden = ?1",nativeQuery = true)
    public String getOrdenTelefono(int id_orden);

    @Query(value= "SELECT op.fecha_orden FROM orden_reparaciones op,vehiculos v,personas p\n" +
            "WHERE op.placa = v.placa\n" +
            "AND v.id_persona = p.id_persona\n" +
            "AND op.id_orden = ?1",nativeQuery = true)
    public String getOrdenFecha(int id_orden);

    @Query(value= "SELECT v.placa FROM orden_reparaciones op,vehiculos v,personas p\n" +
            "WHERE op.placa = v.placa\n" +
            "AND v.id_persona = p.id_persona\n" +
            "AND op.id_orden =?1",nativeQuery = true)
    public String getOrdenPlaca(int id_orden);

    @Query(value= "SELECT v.marca FROM orden_reparaciones op,vehiculos v,personas p\n" +
            "WHERE op.placa = v.placa\n" +
            "AND v.id_persona = p.id_persona\n" +
            "AND op.id_orden = ?1",nativeQuery = true)
    public String getOrdenMarca(int id_orden);

    @Query(value= "SELECT v.modelo FROM orden_reparaciones op,vehiculos v,personas p\n" +
            "WHERE op.placa = v.placa\n" +
            "AND v.id_persona = p.id_persona\n" +
            "AND op.id_orden = ?1",nativeQuery = true)
    public String getOrdenModelo(int id_orden);

    @Modifying
    @org.springframework.transaction.annotation.Transactional
	@Query(value = "UPDATE orden_reparaciones SET diagnostico= ?2 WHERE id_orden = ?1",nativeQuery = true)
	public void actualizarOrdenReparacion(int idOrden, String diagnostico);

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "UPDATE orden_reparaciones SET costo_total = (SELECT SUM(r.costo_total_reparacion) \n" +
            "FROM reparaciones r, orden_reparaciones o\n" +
            "WHERE r.id_orden = o.id_orden\n" +
            "AND o.id_orden = ?1)\n" +
            "WHERE id_orden = ?1",nativeQuery = true)
    public void actualizarCostoTotal(int idOrden);


    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "UPDATE orden_reparaciones SET diagnostico= ?2 WHERE id_orden = ?1",nativeQuery = true)
    public void actualizarCostoTotal(int idOrden, String diagnostico);

    @Query(value= "SELECT  CONCAT(p.id_persona, \" \", p.nombres,\" \",p.apellidos) FROM orden_reparaciones op, personas p\n" +
            "WHERE op.id_empleado = p.id_persona\n" +
            "AND op.id_orden = ?1",nativeQuery = true)
    public String getOrdenMecanico(int idOrden);

}








