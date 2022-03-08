package co.edu.uptc.TecnimecanicaHermanos.repository;

import co.edu.uptc.TecnimecanicaHermanos.domain.OrdenReparacion;
import co.edu.uptc.TecnimecanicaHermanos.domain.Reparacion;
import co.edu.uptc.TecnimecanicaHermanos.domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GeneralRepositoryReparaciones  extends JpaRepository<Reparacion, Integer> {
    @Query(value= "SELECT * FROM reparaciones ORDER BY id_reparacion",nativeQuery = true)
    public List<Reparacion> getReparaciones();

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value= " INSERT INTO reparaciones(costo_servicio,fecha_reparacion,id_servicio,id_orden,costo_total_reparacion) VALUES(?,?,?,?,?)",nativeQuery = true)
    public void registrarReparacion(Integer costo,String fecha_reparacion,int id_servicio,int id_orden,int costo_total_reparacion);

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "DELETE FROM reparaciones WHERE id_reparacion LIKE ?1",nativeQuery = true)
    public void eliminarReparacion(int id_reparacion);

    @Query(value= "SELECT * FROM reparaciones WHERE id_reparacion LIKE ?1 ",nativeQuery = true)
    public Reparacion getReparacionById(int id_reparacion);

   @Query(value= "SELECT * FROM reparaciones WHERE id_orden = ?1 ",nativeQuery = true)
    public List<Reparacion> getReparacionesByIdOrden(int id);

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "UPDATE reparaciones SET fecha_reparacion= ?2,costo_servicio= ?3 WHERE id_reparacion LIKE ?1",nativeQuery = true)
    public void actualizarReparacion(int id_reparacion,String fecha_reparacion,int costo_servicio);

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "UPDATE reparaciones SET costo_total_reparacion=(SELECT IFNULL((SELECT SUM(re.costo_unitario* rp.cantidad_repuesto) + r.costo_servicio\n" +
            "FROM reparaciones r, reparaciones_repuestos rp, repuestos re\n" +
            "WHERE r.id_reparacion = rp.id_reparacion\n" +
            "AND rp.id_repuesto = re.id_repuesto \n" +
            "AND r.id_reparacion=?1),(SELECT costo_servicio FROM reparaciones WHERE id_reparacion=?1))) WHERE id_reparacion=?1",nativeQuery = true)
    public void actualizarReparacionCostoTotal(int id_reparacion);
}
