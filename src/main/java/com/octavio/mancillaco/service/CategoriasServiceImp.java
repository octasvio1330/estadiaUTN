package com.octavio.mancillaco.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.octavio.mancillaco.model.Categoria;

@Service
public class CategoriasServiceImp implements IntCategoriasService {

	private List<Categoria> lista;
	
	public CategoriasServiceImp() {
		lista = new LinkedList<Categoria>();
		
		Categoria c1 = new Categoria();
		c1.setId(1);
		c1.setNombre("Vigilancia");
		c1.setDescripcion("Seguridad chida");
		//**********************************
		Categoria c2 = new Categoria();
		c2.setId(2);
		c2.setNombre("Secretaria");
		c2.setDescripcion("Secretaria director empresa");
		//**********************************
		Categoria c3 = new Categoria();
		c3.setId(3);
		c3.setNombre("Camarografo");
		c3.setDescripcion("Videos y fotos profesionales");
		//***********************************
		Categoria c4 = new Categoria();
		c4.setId(4);
		c4.setNombre("Tecnicos");
		c4.setDescripcion("Relacionado con diferentes areas");
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);
	}
	@Override
	public List<Categoria> obtenerTodas() {
		return lista;
	}

	@Override
	public void guardar(Categoria categoria) {
		lista .add(categoria);
	}

	@Override
	public void eliminar(Integer idCategoria) {
		lista.remove(buscarPorId(idCategoria));
		
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		
		for(Categoria categoria: lista) {
			if(categoria.getId() == idCategoria) {
				return categoria;
			}
		}
		return null;
	}
	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
