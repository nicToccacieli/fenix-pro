package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo, Long>{
	
	public List<Allievo> findByCf(String cf);
	
	public List<Allievo> findAllByAttivitaId(Long id);

}
