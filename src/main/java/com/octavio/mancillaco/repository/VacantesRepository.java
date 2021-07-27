package com.octavio.mancillaco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.octavio.mancillaco.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

	//recupera 
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado,String estatus);
	
	//Metodo que realiza una consulta con sql nativo 
	@Query(value="SELECT * FROM vacantes WHERE destacado= 1\r\n" + "AND estatus = 'Aprobada' ORDER BY id", nativeQuery = true)
	List<Vacante> obtenerTodasDestacadas();
}
