package it.uniroma3.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Attivita;

public interface AttivitaRepository extends CrudRepository<Attivita, Long> {
	
	public List<Attivita> findByNomeAndDataOra(String nome, Date dataOra);

	public List<Attivita> findAllByCentroId(Long id);
	
	public List<Attivita> findAllByAllieviId(Long id);
}
