/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.uptc.TecnimecanicaHermanos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import co.edu.uptc.TecnimecanicaHermanos.domain.Repuestos;


public interface GeneralRepositoryRepuestos extends JpaRepository<Repuestos, Integer>{
	
  //  -------------------------------Clientes---------------------------------------
    
    @Query(value= "SELECT * FROM repuestos ORDER BY id_repuesto",nativeQuery = true)
    public List<Repuestos> getRepuestos();

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value= " INSERT INTO repuestos(nombre_repuesto,costo_unitario,cantidad_inventario) VALUES(?,?,?)",nativeQuery = true)
    public void registrarRepuestos(String nombre,int costoUnitario,int cantidadInventario);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "DELETE FROM repuestos WHERE id_repuesto=?",nativeQuery = true)
	public void eliminarRepuesto(String isServicio);
    
    @Query(value= "SELECT * FROM repuestos WHERE id_repuesto =? ",nativeQuery = true)
	public Repuestos getRepuestoById(String id);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
	@Query(value = "UPDATE repuestos SET nombre_repuesto= ?2, costo_unitario= ?3,cantidad_inventario= ?4 WHERE id_repuesto= ?1",nativeQuery = true)
	public void actualizarRepuesto(String idServicio,String nombre,int costo,int cantidadInventario);

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "UPDATE repuestos SET cantidad_inventario = (SELECT cantidad_inventario FROM repuestos WHERE id_repuesto= ?1)- ?2 \n" +
            "WHERE id_repuesto=?1",nativeQuery = true)
    public void actualizarCantidadRepuesto(int id_repuesto, int cantidadUtilizada);

}








