package com.octavio.mancillaco.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.octavio.mancillaco.model.Vacante;
import com.octavio.mancillaco.repository.VacantesRepository;
import com.octavio.mancillaco.service.IntVacantesService;

@Service
@Primary
public class VacantesServiceJpa implements IntVacantesService {

	@Autowired
	private VacantesRepository repoVacantes;
	
	
	@Override
	public List<Vacante> obtenerTodas() {
		return repoVacantes.findAll();
	}

	@Override
	public void guardar(Vacante vacante) {
		repoVacantes.save(vacante);
	}

	@Override
	public void eliminar(Integer idVacante) {
		repoVacantes.deleteById(idVacante);
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		Optional<Vacante> optional = repoVacantes.findById(idVacante);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Integer numeroVacantes() {
		// TODO Auto-generated method stub
		return repoVacantes.findAll().size();
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoVacantes.findAll(page);
	}

	@Override
	public List<Vacante> obtenerDestacadas() {
		
		return repoVacantes.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	@Override
	public List<Vacante> todasDestacadas() {
		return repoVacantes.obtenerTodasDestacadas();
	}
	
}