package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@Table(uniqueConstraints=@UniqueConstraint(columnNames= {"nome","cognome"}))
public class Allievo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(unique = true ,nullable = false)
	private String cf;
	
	@Column(nullable = false)
	private String indirizzo;
	
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataDiNascita;
	
	@Column(nullable = false)
	private String luogoDiNascita;
	
	private String telefono;
	
	@ManyToOne
	private Docente docente;
	
	@ManyToMany
	private List<Attivita> attivita;
	
	public Allievo() {}
	
	public Allievo(String nome, String cognome, String cf, String ind, String email, Date data, String luogo, String tel, List<Attivita> a) {
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.indirizzo = ind;
		this.email = email;
		this.dataDiNascita = data;
		this.luogoDiNascita = luogo;
		this.telefono = tel;
		this.attivita = a;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(List<Attivita> attivita) {
		this.attivita = attivita;
	}

}
