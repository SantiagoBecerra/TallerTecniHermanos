/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.TecnimecanicaHermanos.services;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import co.edu.uptc.TecnimecanicaHermanos.domain.OrdenReparacion;
import co.edu.uptc.TecnimecanicaHermanos.domain.Personas;
import co.edu.uptc.TecnimecanicaHermanos.domain.Repuestos;
import co.edu.uptc.TecnimecanicaHermanos.domain.Servicios;
import co.edu.uptc.TecnimecanicaHermanos.domain.Vehiculo;
import co.edu.uptc.TecnimecanicaHermanos.repository.GeneralRepositoryOrdenReparacion;
import co.edu.uptc.TecnimecanicaHermanos.repository.GeneralRepositoryPersonas;
import co.edu.uptc.TecnimecanicaHermanos.repository.GeneralRepositoryRepuestoReparaciones;
import co.edu.uptc.TecnimecanicaHermanos.repository.GeneralRepositoryRepuestos;
import co.edu.uptc.TecnimecanicaHermanos.repository.GeneralRepositoryServicios;
import co.edu.uptc.TecnimecanicaHermanos.repository.GeneralRepositoryVehiculos;
//
@Service
public class GeneralServices {
	public final GeneralRepositoryPersonas generalRepositoryPersonas;
	public final GeneralRepositoryServicios generalRepositoryServicios;
	public final GeneralRepositoryRepuestos generalRepositoryRepuestos;
	public final GeneralRepositoryVehiculos generalRepositoryVehiculos;
	public final GeneralRepositoryOrdenReparacion generalRepositoryOrdenReparacion;
	public final GeneralRepositoryRepuestoReparaciones generalRepositoryRepuestoReparacion;

	public GeneralServices(GeneralRepositoryPersonas generalRepository,GeneralRepositoryServicios generalRepositoryServicios,GeneralRepositoryRepuestos generalRepositoryRepuestos
			,GeneralRepositoryVehiculos generalRepositoryVehiculos,GeneralRepositoryOrdenReparacion generalRepositoryOrdenReparacion,GeneralRepositoryRepuestoReparaciones generalRepositoryRepuestoReparacion) {
		this.generalRepositoryPersonas = generalRepository;
		this.generalRepositoryServicios = generalRepositoryServicios;
		this.generalRepositoryRepuestos=generalRepositoryRepuestos;
		this.generalRepositoryVehiculos=generalRepositoryVehiculos;
		this.generalRepositoryOrdenReparacion=generalRepositoryOrdenReparacion;
		this.generalRepositoryRepuestoReparacion=generalRepositoryRepuestoReparacion;
	}

	public Personas getUsuarioLogin(String usuario,String contrasenia){
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

	public void registrarOrdenReparacion(String descripcion,Date fecha,int costoTotal,int empleado,String placa){
		generalRepositoryOrdenReparacion.registrarOrdenReparacion(descripcion, fecha, costoTotal, empleado, placa);
	}

	public void eliminarOrdenReparacion(String documento) {
		generalRepositoryOrdenReparacion.eliminarOrdenReparacion(documento);

	}

	public OrdenReparacion getOrdenReparacionById(String id){
		return generalRepositoryOrdenReparacion.getOrdenReparacionById(id);
	}
	
	public List<OrdenReparacion> getOrdenReparacionByPlaca(String id){
		return generalRepositoryOrdenReparacion.getOrdenReparacionByPlaca(id);
	}

	public void actualizarOrdenReparacion(int idOrden ,String diagnostico,int costoTotal) {
		generalRepositoryOrdenReparacion.actualizarOrdenReparacion(idOrden, diagnostico, costoTotal);
	}  
	
	//----------------------------------Repuestos Reparacion---------------------------------------------
	
	public void registrarRepuestoReparacion(int cantidad,int idRepuesto,int idReparacion){
		generalRepositoryRepuestoReparacion.registrarRepuestoReparacion(cantidad, idRepuesto, idReparacion);
	}
	
	public void getRepuestoReparacionById(String idReparacion){
		generalRepositoryRepuestoReparacion.getRepuestoReparacionById(idReparacion);
	}
}
