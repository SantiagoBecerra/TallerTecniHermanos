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
    
    @Query(value= "SELECT * FROM reparaciones_repuestos WHERE id_reparacion = ?1 ",nativeQuery = true)
	public OrdenReparacion getRepuestoReparacionById(String id);
    
}








