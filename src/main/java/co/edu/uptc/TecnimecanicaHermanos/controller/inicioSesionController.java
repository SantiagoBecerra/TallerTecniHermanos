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
		if(generalService.getUsuarioLogin(usuario,contrasenia) >0){
			return "inicioAdmin";
		}else{
			return "error";
		}
	}
	@RequestMapping("/inicioAdmin")
	public String inicioAdmin(){
		return "inicioAdmin";
	}  
}
