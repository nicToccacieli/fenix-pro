package it.uniroma3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Docente;
import it.uniroma3.repository.DocenteRepository;

@Transactional
@Service
public class DocenteService {
	
	@Autowired
	private DocenteRepository docenteRepository; 
	
	public Docente save(Docente docente) {
		return this.docenteRepository.save(docente);
	}
	
	public List<Docente> findAll() {
		return (List<Docente>) this.docenteRepository.findAll();
	}

	public Docente findById(Long id) {
		Optional<Docente> docente = this.docenteRepository.findById(id);
		if (docente.isPresent()) 
			return docente.get();
		else
			return null;
	}
	
	public boolean alreadyExists(Docente docente) {
		List<Docente> docenti = this.docenteRepository.findByCf(docente.getCf());
		if (docenti.size() > 0)
			return true;
		else 
			return false;
	}	

}
