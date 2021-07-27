package com.octavio.mancillaco.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.octavio.mancillaco.model.Categoria;
import com.octavio.mancillaco.model.Vacante;
@Service
public class VacantesServiceImp implements IntVacantesService {
	
	private List<Vacante> lista;
	
	public VacantesServiceImp() {
		lista = new LinkedList<Vacante>();
		try {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			Vacante v1 =new Vacante();
			v1.setId(1);
			v1.setNombre("programador");
			v1.setDescripcion("Programador en java");
			v1.setSalario(10000.0);
			v1.setFecha(LocalDate.parse("18-09-2017", formato));
			v1.setDestacado(1);
			v1.setEstatus("Creada");
			v1.setImagen("logo3.png");
			v1.setDetalles("<h3><strong>Amplia Experiencia</strong></h3>");
			
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Vigilancia");
			c1.setDescripcion("Seguridad chida");
			v1.setCategoria(c1);
			//*******************************************
			Vacante v2 =new Vacante();
			v2.setId(2);
			v2.setNombre("Diseñador");
			v2.setDescripcion("Diseñador web que diseñe chido xd");
			v2.setSalario(20000.0);
			v2.setFecha(LocalDate.parse("18-09-2020", formato));
			v2.setDestacado(1);
			v2.setEstatus("Aprobada");
			v2.setImagen("logo4.png");
			v2.setDetalles("<h3><strong>Amplia Experiencia</strong></h3>");
			
			Categoria c2 = new Categoria();
			c2.setId(4);
			c2.setNombre("Tecnicos");
			c2.setDescripcion("Relacionado con diferentes areas");
			v2.setCategoria(c2);
			//*******************************************
			Vacante v3 =new Vacante();
			v3.setId(3);
			v3.setNombre("Analista");
			v3.setDescripcion("Analista de Base de datos");
			v3.setSalario(100000.0);
			v3.setFecha(LocalDate.parse("13-09-2021", formato));
			v3.setDestacado(0);
			v3.setEstatus("Eliminada");
			v3.setDetalles("<h3><strong>Amplia Experiencia</strong></h3>");
			
			Categoria c3 = new Categoria();
			c3.setId(3);
			c3.setNombre("Camarografo");
			c3.setDescripcion("Videos y fotos profesionales");
			v3.setCategoria(c3);
			//*******************************************
			Vacante v4 =new Vacante();
			v4.setId(4);
			v4.setNombre("Tecnico");
			v4.setDescripcion("Mantenimiento en computadoras");
			v4.setSalario(300000.0);
			v4.setFecha(LocalDate.parse("13-06-2020", formato));
			v4.setDestacado(1);
			v4.setEstatus("Creada");
			v4.setImagen("logo6.png");
			v4.setDetalles("<h3><strong>Amplia Experiencia</strong></h3>");
			
			Categoria c4 = new Categoria();
			c4.setId(1);
			c4.setNombre("Vigilancia");
			c4.setDescripcion("Seguridad chida");
			v4.setCategoria(c4);
			
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
			lista.add(v4);
			
			
		}catch(DateTimeParseException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	

	@Override
	public List<Vacante> obtenerTodas() {
		return lista;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);

	}

	@Override
	public void eliminar(Integer idVacante) {
		lista.remove(buscarPorId(idVacante));
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for(Vacante v: lista) {
			if(v.getId() == idVacante) {
				return v;
			}
		}
		return null;
	}


	@Override
	public Integer numeroVacantes() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Vacante> obtenerDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Vacante> todasDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}
}
