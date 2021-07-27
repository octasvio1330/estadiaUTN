package com.octavio.mancillaco.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.octavio.mancillaco.model.Perfil;
import com.octavio.mancillaco.model.Usuario;
import com.octavio.mancillaco.model.Vacante;
import com.octavio.mancillaco.service.IntUsuariosService;
import com.octavio.mancillaco.service.IntVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private IntUsuariosService usuariosService;
	@Autowired
	private IntVacantesService vacantesService;
	
	@PostMapping("/guardar")
	public String guardarUsuario(Usuario usuario) {
		
		String modificar ="{noop}" + usuario.getPassword();
		usuario.setPassword(modificar);
		usuario.setEstatus(1); // usuario 1 activo y 0 inactivo 
		usuario.setFechaRegistro(LocalDate.now());
		//Crear el perfil o rol
		Perfil perfil = new Perfil();
		perfil.setId(3); //Rol-Usuario
		usuario.agregar(perfil);
		System.out.println(usuario);
		//Guardar usuario en tabla correspondiente 
		usuariosService.guardar(usuario);
		
		return "formLogin";
	}
	
	
	
	
	@GetMapping("/crear")
	public String crearUsuario(Usuario usuario) {
		return "formRegistro";
	}
	
	@GetMapping("/acerca")
	public String acerca() {
		return "acerca";
	}
	
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Vacante> vacantes =
				vacantesService.todasDestacadas();
		model.addAttribute("vacantes", vacantes);
		return "home";
	}

}