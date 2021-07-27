package com.octavio.mancillaco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.octavio.mancillaco.model.Usuario;
import com.octavio.mancillaco.repository.UsuariosRepository;

@Service
public class UsuariosServiceJpa implements IntUsuariosService {

	@Autowired
	private UsuariosRepository repoUsuarios;
	
	@Override
	public List<Usuario> obtenerTodas() {
		
		return repoUsuarios.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		repoUsuarios.save(usuario);

	}

	@Override
	public void eliminar(Integer idUsuario) {
		repoUsuarios.deleteById(idUsuario);

	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		Optional<Usuario> optional = repoUsuarios.findById(idUsuario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Page<Usuario> buscarTodas(Pageable page) {
		return repoUsuarios.findAll(page);
	}

	@Override
	public Integer numeroEntidades() {
		//return repoUsuarios.findAll().size();
		return repoUsuarios.totalEntidades();
	}

}
