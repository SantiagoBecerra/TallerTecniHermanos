package co.edu.uptc.TecnimecanicaHermanos.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.uptc.TecnimecanicaHermanos.domain.Personas;
import co.edu.uptc.TecnimecanicaHermanos.services.GeneralServices;


@Controller
public class inicioSesionController {


	private final GeneralServices generalService;
	public inicioSesionController(GeneralServices generalService) {
		this.generalService = generalService;
	} 

	@RequestMapping("/")
	public String showLogin(){
		return "login";
	}   

	@RequestMapping("/search_user")
	public String getUsuarioRegistrado(@RequestParam("u") String usuario,@RequestParam("c") String contrasenia, Model model){
		Personas featured = generalService.getUsuarioLogin(usuario,contrasenia);
		model.addAttribute("cantidad","hola"+ featured.getNombres()+" Usuario: "+featured.getUser()+" Contraseña: "+featured.getPass()+" Tipo usuario: "+ featured.getTipo_persona());
		return "inicioAdmin";
	}
	
	@RequestMapping("/inicioAdmin")
	public String inicioAdmin(){
		return "inicioAdmin";
	}  
}
