package com.octavio.mancillaco.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.octavio.mancillaco.model.Usuario;

public interface IntUsuariosService {

	public List <Usuario> obtenerTodas();
	public void guardar(Usuario usuario);
	public void eliminar(Integer idUsuario);
	public Usuario buscarPorId(Integer idUsuario);
	
	public Page <Usuario>buscarTodas(Pageable page);
	public Integer numeroEntidades();
	
	public Usuario buscarPorUsername(String username);
}
