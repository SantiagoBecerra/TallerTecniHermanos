/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.TecnimecanicaHermanos.services;

import java.util.Date;
import java.util.List;

import co.edu.uptc.TecnimecanicaHermanos.domain.*;
import co.edu.uptc.TecnimecanicaHermanos.repository.*;
import org.springframework.stereotype.Service;

//
@Service
public class GeneralServices {
	public final GeneralRepositoryPersonas generalRepositoryPersonas;
	public final GeneralRepositoryServicios generalRepositoryServicios;
	public final GeneralRepositoryRepuestos generalRepositoryRepuestos;
	public final GeneralRepositoryVehiculos generalRepositoryVehiculos;
	public final GeneralRepositoryOrdenReparacion generalRepositoryOrdenReparacion;
	public final GeneralRepositoryRepuestoReparaciones generalRepositoryRepuestoReparacion;
	public final GeneralRepositoryReparaciones generalRepositoryReparaciones;
	public GeneralServices(GeneralRepositoryPersonas generalRepository,GeneralRepositoryServicios generalRepositoryServicios,GeneralRepositoryRepuestos generalRepositoryRepuestos
			,GeneralRepositoryVehiculos generalRepositoryVehiculos,GeneralRepositoryOrdenReparacion generalRepositoryOrdenReparacion,GeneralRepositoryRepuestoReparaciones generalRepositoryRepuestoReparacion,
						   GeneralRepositoryReparaciones generalRepositoryReparaciones) {
		this.generalRepositoryPersonas = generalRepository;
		this.generalRepositoryServicios = generalRepositoryServicios;
		this.generalRepositoryRepuestos=generalRepositoryRepuestos;
		this.generalRepositoryVehiculos=generalRepositoryVehiculos;
		this.generalRepositoryOrdenReparacion=generalRepositoryOrdenReparacion;
		this.generalRepositoryRepuestoReparacion=generalRepositoryRepuestoReparacion;
		this.generalRepositoryReparaciones = generalRepositoryReparaciones;
	}

	public Integer getUsuarioLogin(String usuario,String contrasenia){
		return generalRepositoryPersonas.getUsuarioLogin(usuario, contrasenia);
	}

	public List<Personas> getClientes(){
		return generalRepositoryPersonas.getClientes();
	}

	public void registrarCliente(String nombre ,String apellido,String numeroDocumento,String telefono,String direccion, char tipoPersona){
		generalRepositoryPersonas.registrarCliente(nombre, apellido, numeroDocumento, direccion, telefono,tipoPersona);
	}

	public void eliminarCliente(String documento) {
		generalRepositoryPersonas.eliminarCliente(documento);

	}

	public Personas getClienteById(String id){
		return generalRepositoryPersonas.getClienteById(id);
	}

	public void actualizarCliente(String documento,String nombres, String apellidos, String telefono, String direccion) {
		generalRepositoryPersonas.actualizarCliente(documento, nombres, apellidos,  telefono,  direccion);

	}
	//    ------------------------------------empleados---------------------------

	public List<Personas> getEmpleados(){
		return generalRepositoryPersonas.getEmpleados();
	}

	public void registrarEmpleado(String nombre ,String apellido,String numeroDocumento,String telefono,String direccion, char tipoPersona,char tipoEmpleado){
		generalRepositoryPersonas.registrarEmpleado(nombre, apellido, numeroDocumento, direccion, telefono,tipoPersona,tipoEmpleado);
	}

	public void eliminarEmpleado(String documento) {
		generalRepositoryPersonas.eliminarEmpleado(documento);

	}

	public Personas getEmpleadoById(String id){
		return generalRepositoryPersonas.getEmpleadoById(id);
	}
	
	public Personas getEmpleadoByLastName(String id){
		return generalRepositoryPersonas.getEmpleadoByLastName(id);
	}

	public void actualizarEmpleado(String documento,String nombres, String apellidos, String telefono, String direccion,char tipoEmpleado) {
		generalRepositoryPersonas.actualizarEmpleado(documento, nombres, apellidos,  telefono,  direccion, tipoEmpleado);

	}  


	//    ---------------------------------------servicios---------------------------------------

	public List<Servicios> getServicios(){
		return generalRepositoryServicios.getServicios();
	}

	public void registrarServicio(String nombre){
		generalRepositoryServicios.registrarServicio(nombre);
	}

	public void eliminarServicio(String documento) {
		generalRepositoryServicios.eliminarServicios(documento);

	}

	public Servicios getServicioById(String id){
		return generalRepositoryServicios.getServicioById(id);
	}

	public void actualizarServicio(String documento,String nombres) {
		generalRepositoryServicios.actualizarServicio(documento, nombres);

	}  

	//    ----------------------------------repuestos---------------------------------------------

	public List<Repuestos> getRepuestos(){
		return generalRepositoryRepuestos.getRepuestos();
	}

	public void registrarRepuesto(String nombre,int cantidad,int cantidadInventario){
		generalRepositoryRepuestos.registrarRepuestos(nombre, cantidad, cantidadInventario);
	}

	public void eliminarRepuesto(String documento) {
		generalRepositoryRepuestos.eliminarRepuesto(documento);

	}

	public Repuestos getRepuestoById(String id){
		return generalRepositoryRepuestos.getRepuestoById(id);
	}

	public void actualizarRepuesto(String documento,String nombres,int cantidad,int cantidadInventario) {
		generalRepositoryRepuestos.actualizarRepuesto(documento, nombres, cantidad, cantidadInventario);

	}  

	//  ----------------------------------vehiculos---------------------------------------------

	public List<Vehiculo> getVehiculos(){
		return generalRepositoryVehiculos.getVehiculos();
	}

	public void registrarVehiculos(String placa,String modelo,String marca,String color,int anio,String descripcion,int duenio){
		generalRepositoryVehiculos.registrarVehiculo(placa,modelo,marca,color,anio,descripcion,duenio);
	}

	public void eliminarVehiculo(String documento) {
		generalRepositoryVehiculos.eliminarVehiculo(documento);

	}

	public Vehiculo getVehiculoById(String id){
		return generalRepositoryVehiculos.getVehiculoById(id);
	}

	public List<Vehiculo> getVehiculoByIdPersona(String id){
		return generalRepositoryVehiculos.getVehiculoByIdPersona(id);
	}

	public void actualizarVehiculo(String placa,String modelo,String marca,String color,int anio,String descripcion,int duenio) {
		generalRepositoryVehiculos.actualizarVehiculo(placa,modelo,marca,color,anio,descripcion,duenio);

	}  

	//----------------------------------Orden Reparacion---------------------------------------------

	public List<OrdenReparacion> getOrdene(){
		return generalRepositoryOrdenReparacion.getOrdenesReparaciones();
	}

	public void registrarOrdenReparacion(String descripcion,String fecha,int empleado,String placa){
		generalRepositoryOrdenReparacion.registrarOrdenReparacion(descripcion, fecha, empleado, placa);
	}

	public void eliminarOrdenReparacion(String documento) {
		generalRepositoryOrdenReparacion.eliminarOrdenReparacion(documento);

	}
	public Integer getCostoTotalOrden(int idOrden) {
		return generalRepositoryOrdenReparacion.getCostoTotal(idOrden);
	}


	public OrdenReparacion getOrdenReparacionById(String id){
		return generalRepositoryOrdenReparacion.getOrdenReparacionById(id);
	}
	public OrdenReparacion getOrdenReparacionByIdOrden(int id){
		return generalRepositoryOrdenReparacion.getOrdenReparacionByIdOrden(id);
	}
	
	public List<OrdenReparacion> getOrdenReparacionByPlaca(String id){
		return generalRepositoryOrdenReparacion.getOrdenReparacionByPlaca(id);
	}
	public List<OrdenReparacion> getOrdenReparacionByIdEmpleado(int id){
		return generalRepositoryOrdenReparacion.getOrdenReparacionByIdEmpleado(id);
	}

	public void actualizarOrdenReparacion(int idOrden ,String diagnostico) {
		generalRepositoryOrdenReparacion.actualizarOrdenReparacion(idOrden, diagnostico);
	}
	public String getOrdenNombre(int id_orden){
		return generalRepositoryOrdenReparacion.getOrdenNombres(id_orden);
	}
	public String getOrdenApellidos(int id){
		return generalRepositoryOrdenReparacion.getOrdenApellidos(id);
	}
	public String getOrdenDocumento(int id){
		return generalRepositoryOrdenReparacion.getOrdenDocumento(id);
	}
	public String getOrdenDireccion(int id){
		return generalRepositoryOrdenReparacion.getOrdenDireccion(id);
	}
	public String getOrdenTelefono(int id){
		return generalRepositoryOrdenReparacion.getOrdenTelefono(id);
	}
	public String getOrdenFecha(int id){
		return generalRepositoryOrdenReparacion.getOrdenFecha(id);
	}
	public String getOrdenPlaca(int id){
		return generalRepositoryOrdenReparacion.getOrdenPlaca(id);
	}
	public String getOrdeMarca(int id){
		return generalRepositoryOrdenReparacion.getOrdenMarca(id);
	}
	public String getOrdenModelo(int id){
		return generalRepositoryOrdenReparacion.getOrdenModelo(id);
	}

	//----------------------------------Reparaciones---------------------------------------------

	public List<Reparacion> getReparaciones(){
		System.out.println(generalRepositoryReparaciones.getReparaciones());
		return generalRepositoryReparaciones.getReparaciones();
	}

	public void registrarReparacion(Integer costo,String fecha,int id_servicio,int id_Orden){
		generalRepositoryReparaciones.registrarReparacion(costo, fecha, id_servicio, id_Orden,costo);
		generalRepositoryOrdenReparacion.actualizarCostoTotal(id_Orden);
	}

	public void eliminarReparacion(int id_reparacion, int idOrden) {
		generalRepositoryReparaciones.eliminarReparacion(id_reparacion);
		generalRepositoryOrdenReparacion.actualizarCostoTotal(idOrden);
	}

	public Reparacion getReparacionById(int id_reparacion){
		return generalRepositoryReparaciones.getReparacionById(id_reparacion);
	}
	public List<Reparacion> getReparacionesById(int id){
		return generalRepositoryReparaciones.getReparacionesByIdOrden(id);
	}
	public void actualizarReparacion(int idReparacion ,String fecha_reparacion,int costo_servicio, int idOrden) {
		generalRepositoryReparaciones.actualizarReparacion(idReparacion, fecha_reparacion,costo_servicio);
		generalRepositoryReparaciones.actualizarReparacionCostoTotal(idReparacion);
		generalRepositoryOrdenReparacion.actualizarCostoTotal(idOrden);
	}

	//----------------------------------Repuestos Reparacion---------------------------------------------
	
	public void registrarRepuestoReparacion(int cantidad,int idRepuesto,int idReparacion, int id_orden){
		generalRepositoryRepuestoReparacion.registrarRepuestoReparacion(cantidad, idRepuesto, idReparacion);
		generalRepositoryRepuestos.actualizarCantidadRepuesto(idRepuesto,cantidad);
		generalRepositoryReparaciones.actualizarReparacionCostoTotal(idReparacion);
		generalRepositoryOrdenReparacion.actualizarCostoTotal(id_orden);
	}
	
	public List<String> getRepuestoReparacionById(int idReparacion){
		return generalRepositoryRepuestoReparacion.getRepuestoReparacionById(idReparacion);
	}

	public List<Integer> getCantidadRepuestosUsados(int id_reparacion) {
		return generalRepositoryRepuestoReparacion.getCantidadRepuestosUsados(id_reparacion);
	}
	public List<Integer> getIdsRepuestosUsados(int id_reparacion) {
		return generalRepositoryRepuestoReparacion.getIdsRepuestos(id_reparacion);
	}

	public List<Integer> getIdsReparacion(int idOrden){
		return generalRepositoryRepuestoReparacion.getIdsReparaciones(idOrden);
	}

	public List<String> getNombreRepuestos(int idOrden) {
		return generalRepositoryRepuestoReparacion.getNombreRepuestos(idOrden);
	}
	public List<Integer> getCantidad(int idOrden) {
		return generalRepositoryRepuestoReparacion.getCantidad(idOrden);
	}
	public List<Integer> getCostoUnitario(int idOrden) {
		return generalRepositoryRepuestoReparacion.getCostoUnitario(idOrden);
	}
	public List<Integer> getCostoTotal(int idOrden) {
		return generalRepositoryRepuestoReparacion.getCostoTotal(idOrden);
	}

	public void eliminarRepuestoAsignado(int id_repuesto, int id_reparacion, int id_orden) {
		generalRepositoryRepuestoReparacion.eliminarRepuestoAsignado(id_repuesto,id_reparacion);
		generalRepositoryReparaciones.actualizarReparacionCostoTotal(id_reparacion);
		generalRepositoryOrdenReparacion.actualizarCostoTotal(id_orden);
	}

	public String getOrdenMecanico(int idOrden) {
		return generalRepositoryOrdenReparacion.getOrdenMecanico(idOrden);
	}
}
