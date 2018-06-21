package it.uniroma3;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.uniroma3.model.Allievo;
import it.uniroma3.model.Attivita;
import it.uniroma3.model.Centro;
import it.uniroma3.model.Docente;
import it.uniroma3.model.Responsabile;
import it.uniroma3.service.AllievoService;
import it.uniroma3.service.AttivitaService;
import it.uniroma3.service.CentroService;
import it.uniroma3.service.DocenteService;
import it.uniroma3.service.ResponsabileService;

@SpringBootApplication
public class FenixApplication {
	
	@Autowired
	private ResponsabileService responsabileService;
	
	@Autowired
	private CentroService centroService;
	
	@Autowired 
	private AttivitaService attivitaService;
	
	@Autowired 
	private DocenteService docenteService;
	
	@Autowired
	private AllievoService allievoService;

	public static void main(String[] args) {
		SpringApplication.run(FenixApplication.class, args);
	}
	
	@SuppressWarnings("deprecation")
	@PostConstruct 
	public void init() {
		Centro c1 = new Centro("Sistemi Informatici", "Vicolo stretto", "sistinf@fenixpro.com", 061234567, 150);
		centroService.save(c1);
		
		Centro c2 = new Centro("Aviazione Civile", "Vicolo corto", "avciv@fenixpro.com", 066432654, 80);
		centroService.save(c2);
		
		Centro c3 = new Centro("Arte", "Parco della Vittoria", "art@fenixpro.com", 061234566, 200);
		centroService.save(c3);
		
		Centro c4 = new Centro("Moda & Bellezza", "Piazza Universita'", "modbel@fenixpro.com", 061234565, 180);
		centroService.save(c4);
		
		Responsabile r1 = new Responsabile("Mario", "Rossi", "RSSMRO85B12H501G", c3);
		responsabileService.save(r1);
		
		Responsabile r2 = new Responsabile("Federica", "Verdi", "VRDFDR91C14H501G", c2);
		responsabileService.save(r2);
		
		Responsabile r3 = new Responsabile("Nikola", "Tesla", "TSLNKL86R18Z501G", c1);
		responsabileService.save(r3);
		
		Responsabile r4 = new Responsabile("Sofia", "Vergara", "VRGSFA72G26H501G", c4);
		responsabileService.save(r4);
		
		Attivita a1 = new Attivita("SIW", new Date(118,07,10,12,30), c1, new ArrayList<Allievo>());
		attivitaService.save(a1);
		
		Attivita a2 = new Attivita("APS", new Date(118,07,11,10,30), c1, new ArrayList<Allievo>());
		attivitaService.save(a2);
		
		Attivita a3 = new Attivita("Design", new Date(118,07,10,12,30), c4, new ArrayList<Allievo>());
		attivitaService.save(a3);
		
		Attivita a4 = new Attivita("Studio della struttura degli Aereoporti", new Date(118,07,18,10,00), c2, new ArrayList<Allievo>());
		attivitaService.save(a4);
		
		Attivita a5 = new Attivita("Arte Contemporanea", new Date(118,07,17,11,00), c3, new ArrayList<Allievo>());
		attivitaService.save(a5);
		
		Docente d1 = new Docente("Paolo", "Merialdo", "MRLPLA64D23P403T", a1);
		docenteService.save(d1);
		
		Docente d2 = new Docente("Luca", "Cabibbo", "CBBLCU60H10H501T", a2);
		docenteService.save(d2);
		
		Docente d3 = new Docente("Elisabetta", "Franchi", "FRNLSB62F05G542E", a3);
		docenteService.save(d3);
		
		Docente d4 = new Docente("Andrea", "Benedetto", "BNDNDR78G15H501D", a4);
		docenteService.save(d4);
		
		Docente d5 = new Docente("Piera", "Repice", "RPEPRI45S25H501E", a5);
		docenteService.save(d5);
		
		Allievo al1 = new Allievo("Alessandro", "Perrone", "PRRLSN96C26H501D", "viale dei giardini", "alessandro@perrone.it", new Date(96,03,26), "Roma", "062451242", new ArrayList<Attivita>());
		al1.getAttivita().add(a1);
		al1.getAttivita().add(a2);
		al1.getAttivita().add(a4);
		al1.getAttivita().add(a5);
		allievoService.save(al1);
		
		Allievo al2 = new Allievo("Nina", "Lukic", "LKCNNI86I66R88KZ", "via dei parioli", "nina@lukic.it", new Date(86,10,30), "Belgrado", "065641242", new ArrayList<Attivita>());
		al2.getAttivita().add(a1);
		al2.getAttivita().add(a3);
		al2.getAttivita().add(a4);
		allievoService.save(al2);
		
		Allievo al3 = new Allievo("Nicholas", "Toccacieli", "TCCNHL95B10H501G", "via tallone", "nicholas@toccacieli.it", new Date(95,02,10), "Roma", "0666145123", new ArrayList<Attivita>());
		al3.getAttivita().add(a2);
		al3.getAttivita().add(a4);
		al3.getAttivita().add(a5);
		allievoService.save(al3);
		
		a1.getAllievi().add(al1);
		a1.getAllievi().add(al2);
		attivitaService.save(a1);
		
		a2.getAllievi().add(al1);
		a2.getAllievi().add(al3);
		attivitaService.save(a2);
		
		a3.getAllievi().add(al2);
		attivitaService.save(a3);
		
		a5.getAllievi().add(al3);
		a5.getAllievi().add(al1);
		attivitaService.save(a5);
		
		a4.getAllievi().add(al3);
		a4.getAllievi().add(al2);
		a4.getAllievi().add(al1);
		attivitaService.save(a4);
		
	}
	
}
