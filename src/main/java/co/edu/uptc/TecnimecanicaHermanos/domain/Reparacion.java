package co.edu.uptc.TecnimecanicaHermanos.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reparaciones" , schema = "taller_tecni_hermanos")
public class Reparacion {
    @Id
    @GeneratedValue
    @Column(name="id_reparacion")
    Integer id_reparacion;

    @Column(name="costo_servicio")
    Integer costo_servicio;

    @Column(name = "fecha_reparacion")
    String fecha_reparacion;

    @Column(name = "costo_total_reparacion")
    Integer costo_total_reparacion;

    @ManyToOne
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden")
    OrdenReparacion id_orden;

    @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    Servicios id_servicio;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_reparacion")
    private List<RepuestosReparacion> repuestosReparacions;

    public Reparacion(Integer id_reparacion, Servicios id_servicio, OrdenReparacion id_orden,Integer costo_servicio, String fechaReparacion, Integer costo_total_reparacion) {
        this.id_reparacion = id_reparacion;
        this.costo_servicio = costo_servicio;
        this.costo_total_reparacion = costo_total_reparacion;
        this.id_servicio = id_servicio;
        this.id_orden = id_orden;
        this.fecha_reparacion = fechaReparacion;
    }
    public Reparacion(){
    }

    public Integer getId_reparacion() {
        return id_reparacion;
    }

    public void setId_reparacion(Integer id_reparacion) {
        this.id_reparacion = id_reparacion;
    }

    public Integer getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(Integer costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public String getFecha_reparacion() {
        return fecha_reparacion;
    }

    public void setFecha_reparacion(String fecha_reparacion) {
        this.fecha_reparacion = fecha_reparacion;
    }

    public Integer getCosto_total_reparacion() {
        return costo_total_reparacion;
    }

    public void setCosto_total_reparacion(Integer costo_total_reparacion) {
        this.costo_total_reparacion = costo_total_reparacion;
    }

    public OrdenReparacion getId_orden() {
        return id_orden;
    }

    public void setId_orden(OrdenReparacion id_orden) {
        this.id_orden = id_orden;
    }

    public Servicios getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Servicios id_servicio) {
        this.id_servicio = id_servicio;
    }

    public List<RepuestosReparacion> getRepuestosReparacions() {
        return repuestosReparacions;
    }

    public void setRepuestosReparacions(List<RepuestosReparacion> repuestosReparacions) {
        this.repuestosReparacions = repuestosReparacions;
    }
}
