package com.octavio.mancillaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.octavio.mancillaco.model.Categoria;
import com.octavio.mancillaco.service.IntCategoriasService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	//Instancia inyectada
	@Autowired
	private IntCategoriasService categoriasService;
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id") int idCategoria, Model model) {
	Categoria categoria = categoriasService.buscarPorId(idCategoria);
	System.out.println(categoria);
	model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int idCategoria, RedirectAttributes attribute) {
		//System.out.println("idCategoria = " + idCategoria);
		attribute.addFlashAttribute("msg1", "¡Tipo de vela eliminada con exito!");
		categoriasService.eliminar(idCategoria);
		return "redirect:/categorias/indexPaginado";		
	}
	
	@PostMapping("/guardar")
	//Data Binding (Vincular datos entre una clase modelo y un formulario)
	public String guardar(Categoria categoria, RedirectAttributes attribute) {
		//Esta linea es para incrementar el id con colecciones 
		//categoria.setId(categoriasService.obtenerTodas().size()+1);
		System.out.println(categoria);
		categoriasService.guardar(categoria);
		
		attribute.addFlashAttribute("msg", "¡Tipo de vela guardada con exito!");
		return "redirect:/categorias/indexPaginado";
		
		
	}
	
	/*@PostMapping("/guardar")
	
	public String guardar(@RequestParam("nombre")String nombre, @RequestParam("descripcion")String descripcion, 
			Model model) {
		/*System.out.print("Nombre:" + nombre);
		System.out.print("Descripción:" + descripcion);
		Categoria c = new Categoria();
		c.setId(categoriasService.obtenerTodas().size()+1);
		c.setNombre(nombre);
		c.setDescripcion(descripcion);
		categoriasService.guardar(c);
		model.addAttribute("categorias", categoriasService.obtenerTodas());
		return "categorias/listaCategorias";
	}*/
	
	@GetMapping ("/crear")
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	@GetMapping(value = "/indexPaginado")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Categoria> lista = categoriasService.buscarTodas(page);
	model.addAttribute("categorias", lista);
	return "categorias/listaCategorias";
	}

	
	@GetMapping ("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("categorias", categoriasService.obtenerTodas());
		for(Categoria categoria : categoriasService.obtenerTodas()) {
		System.out.println(categoria);
		}
		return "categorias/listaCategorias";
	}

}
