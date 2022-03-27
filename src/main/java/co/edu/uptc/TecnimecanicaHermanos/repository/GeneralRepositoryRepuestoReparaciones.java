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
import co.edu.uptc.TecnimecanicaHermanos.domain.RepuestosReparacion;
import co.edu.uptc.TecnimecanicaHermanos.domain.Servicios;
import co.edu.uptc.TecnimecanicaHermanos.domain.Vehiculo;


public interface GeneralRepositoryRepuestoReparaciones extends JpaRepository<RepuestosReparacion, Integer>{
	
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value= " INSERT INTO reparaciones_repuestos (cantidad_repuesto,id_repuesto,id_reparacion) VALUES(?,?,?)",nativeQuery = true)
    public void registrarRepuestoReparacion(int cantidad,int repuesto,int idReparacion);

    @Query(value= "SELECT re.nombre_repuesto FROM reparaciones_repuestos rp, repuestos re \n" +
            "WHERE rp.id_reparacion = ?1 \n" +
            "AND rp.id_repuesto = re.id_repuesto ",nativeQuery = true)
	public List<String> getRepuestoReparacionById(int id_reparacion);

    @Query(value= "SELECT rp.cantidad_repuesto FROM reparaciones_repuestos rp, repuestos re \n" +
            "WHERE rp.id_reparacion = ?1 \n" +
            "AND rp.id_repuesto = re.id_repuesto ",nativeQuery = true)
    public List<Integer> getCantidadRepuestosUsados(int id_reparacion);

    @Query(value= "SELECT id_repuesto\n" +
            "FROM reparaciones_repuestos\n" +
            "WHERE id_reparacion = ?1",nativeQuery = true)
    public List<Integer> getIdsRepuestos(int id_reparacion);

    @Query(value= "SELECT r.id_reparacion FROM orden_reparaciones op,reparaciones r, reparaciones_repuestos rp,repuestos re\n" +
            "WHERE op.id_orden = r.id_orden\n" +
            "AND r.id_reparacion = rp.id_reparacion\n" +
            "AND re.id_repuesto = rp.id_repuesto\n" +
            "AND op.id_orden =?1",nativeQuery = true)
    public List<Integer> getIdsReparaciones(int id_orden);

    @Query(value= "SELECT re.nombre_repuesto FROM orden_reparaciones op,reparaciones r, reparaciones_repuestos rp,repuestos re\n" +
            "WHERE op.id_orden = r.id_orden\n" +
            "AND r.id_reparacion = rp.id_reparacion\n" +
            "AND re.id_repuesto = rp.id_repuesto\n" +
            "AND op.id_orden = ?1 ",nativeQuery = true)
    public List<String> getNombreRepuestos(int id_orden);

    @Query(value= "SELECT rp.cantidad_repuesto FROM orden_reparaciones op,reparaciones r, reparaciones_repuestos rp,repuestos re\n" +
            "WHERE op.id_orden = r.id_orden\n" +
            "AND r.id_reparacion = rp.id_reparacion\n" +
            "AND re.id_repuesto = rp.id_repuesto\n" +
            "AND op.id_orden = ?1 ",nativeQuery = true)
    public List<Integer> getCantidad(int id_orden);

    @Query(value= "SELECT re.costo_unitario FROM orden_reparaciones op,reparaciones r, reparaciones_repuestos rp,repuestos re\n" +
            "WHERE op.id_orden = r.id_orden\n" +
            "AND r.id_reparacion = rp.id_reparacion\n" +
            "AND re.id_repuesto = rp.id_repuesto\n" +
            "AND op.id_orden = ?1 ",nativeQuery = true)
    public List<Integer> getCostoUnitario(int id_orden);

    @Query(value= "SELECT rp.cantidad_repuesto*re.costo_unitario FROM orden_reparaciones op,reparaciones r, reparaciones_repuestos rp,repuestos re\n" +
            "WHERE op.id_orden = r.id_orden\n" +
            "AND r.id_reparacion = rp.id_reparacion\n" +
            "AND re.id_repuesto = rp.id_repuesto\n" +
            "AND op.id_orden = ?1",nativeQuery = true)
    public List<Integer> getCostoTotal(int id_orden);

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value= "DELETE FROM reparaciones_repuestos \n" +
            "WHERE id_reparacion = ?2 \n" +
            "AND id_repuesto = ?1",nativeQuery = true)
    public void eliminarRepuestoAsignado(int id_repuesto, int id_reparacion);

}








