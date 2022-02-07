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
import co.edu.uptc.TecnimecanicaHermanos.domain.Servicios;


public interface GeneralRepositoryServicios extends JpaRepository<Servicios, Integer>{
	
  //  -------------------------------Clientes---------------------------------------
    
    @Query(value= "SELECT * FROM Servicios ORDER BY id_servicio",nativeQuery = true)
    public List<Servicios> getServicios();
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value= " INSERT INTO servicios(nombre_servicio) VALUES(?)",nativeQuery = true)
    public void registrarServicio(String nombre);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "DELETE FROM Servicios WHERE id_servicio=?",nativeQuery = true)
	public void eliminarServicios(String isServicio);
    
    @Query(value= "SELECT * FROM servicios WHERE id_servicio =? ",nativeQuery = true)
	public Servicios getServicioById(String id);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
	@Query(value = "UPDATE Servicios SET nombre_servicio= ?2 WHERE id_servicio= ?1",nativeQuery = true)
	public void actualizarServicio(String idServicio,String nombre);
    
}








