package com.octavio.mancillaco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.octavio.mancillaco.model.Usuario;
import com.octavio.mancillaco.service.IntUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private IntUsuariosService usuariosService;

	@GetMapping(value = "/indexPaginado")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Usuario> lista = usuariosService.buscarTodas(page);
		model.addAttribute("usuarios", lista);
		model.addAttribute("total", usuariosService.numeroEntidades());
		return "usuarios/listaUsuarios";
	}

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Usuario> lista = usuariosService.obtenerTodas();
		model.addAttribute("usuarios", lista);
		model.addAttribute("total", usuariosService.numeroEntidades());
		return "usuarios/listaUsuarios";

	}

}
