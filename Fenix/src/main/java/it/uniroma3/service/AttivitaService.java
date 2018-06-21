package it.uniroma3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Attivita;
import it.uniroma3.repository.AttivitaRepository;

@Transactional
@Service
public class AttivitaService {

	@Autowired
	private AttivitaRepository attivitaRepository; 
	
	public Attivita save(Attivita attivita) {
		return this.attivitaRepository.save(attivita);
	}
	
	public List<Attivita> findAll() {
		return (List<Attivita>) this.attivitaRepository.findAll();
	}

	public Attivita findById(Long id) {
		Optional<Attivita> attivita = this.attivitaRepository.findById(id);
		if (attivita.isPresent()) 
			return attivita.get();
		else
			return null;
	}
	
	public boolean alreadyExists(Attivita attivita) {
		List<Attivita> nAttivita = this.attivitaRepository.findByNomeAndDataOra(attivita.getNome(), attivita.getDataOra());
		if (nAttivita.size() > 0)
			return true;
		else 
			return false;
	}	
	
	public List<Attivita> findAllByCentroId(Long id){
		return this.attivitaRepository.findAllByCentroId(id);
	}
	
	public List<Attivita> findAllByAllieviId(Long id){
		return this.attivitaRepository.findAllByAllieviId(id);
	}
	
}
