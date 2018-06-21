package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Docente;

public interface DocenteRepository extends CrudRepository<Docente, Long>{
	
	public List<Docente> findByCf(String cf);

}
