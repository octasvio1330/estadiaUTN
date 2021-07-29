package com.octavio.mancillaco.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	@GetMapping("/logout")
	       public String logout(HttpServletRequest request){
	       SecurityContextLogoutHandler logoutHandler = 
	       new SecurityContextLogoutHandler();
	       logoutHandler.logout(request, null, null);
	return "redirect:/";
	}
	
	@GetMapping("/login")
	public String mostrarLogin() {
		return "formLogin";
		
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Authentication auth,HttpSession session) {
		String username = auth.getName();
		//Obtener el usuario actual 
		
		
		System.out.println("Username : " + username);
		for(GrantedAuthority rol:auth.getAuthorities()) {
			System.out.println("Rol : " + rol.getAuthority());
		}
		
		if(session.getAttribute("usuario") == null) {
		Usuario usuario = usuariosService.buscarPorUsername(username);
		session.setAttribute("usuario", usuario);
		usuario.setPassword(null);
		System.out.println(usuario);
		}
		return "redirect:/";
		
	}
	
	@PostMapping("/guardar")
	public String guardarUsuario(Usuario usuario) {
		
		String modificar ="{noop}" + usuario.getPassword();
		usuario.setPassword(modificar);
		usuario.setEstatus(1); // usuario 1 activo y 0 inactivo 
		usuario.setFechaRegistro(LocalDate.now());
		//Crear el perfil o rol
		Perfil perfil = new Perfil();
		perfil.setId(2); //Rol-Usuario
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