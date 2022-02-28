package co.edu.uptc.TecnimecanicaHermanos.repository;

import co.edu.uptc.TecnimecanicaHermanos.domain.OrdenReparacion;
import co.edu.uptc.TecnimecanicaHermanos.domain.Reparacion;
import co.edu.uptc.TecnimecanicaHermanos.domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GeneralRepositoryReparaciones  extends JpaRepository<OrdenReparacion, Integer> {
    @Query(value= "SELECT * FROM reparaciones ORDER BY id_reparacion",nativeQuery = true)
    public List<Reparacion> getReparaciones();

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value= " INSERT INTO reparaciones(costo_servicio,fecha_reparacion,id_servicio,id_orden) VALUES(?,?,?,?)",nativeQuery = true)
    public void registrarReparacion(Integer costo,String fecha_reparacion,int id_servicio,int id_orden);

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "DELETE FROM reparaciones WHERE id_reparacion LIKE ?",nativeQuery = true)
    public void eliminarReparacion(int id_reparacion);

    @Query(value= "SELECT * FROM reparaciones WHERE id_reparacion LIKE ?1 ",nativeQuery = true)
    public Reparacion getReparacionById(int id_reparacion);

   @Query(value= "SELECT * FROM reparaciones WHERE id_orden = ?1 ",nativeQuery = true)
    public List<Reparacion> getReparacionesByIdOrden(int id);

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "UPDATE reparaciones SET fecha_reparacion= ?2,costo_servicio= ?3 WHERE id_reparacion LIKE ?1",nativeQuery = true)
    public void actualizarReparacion(int id_reparacion,String fecha_reparacion,int costo_servicio);

}
