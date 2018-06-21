package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Centro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String indirizzo;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private int telefono;
	
	@Column(nullable = false)
	private int capienza;
	
	@OneToMany(mappedBy = "centro")
	private List<Attivita> attivita;
	
	@OneToOne(mappedBy = "centro")
	private Responsabile responsabile;
	
	public Centro() {}
	
	public Centro(String name, String ind, String email, int tel, int cap) {
		this.nome = name;
		this.indirizzo = ind;
		this.email = email;
		this.telefono = tel;
		this.capienza = cap;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public Long getId() {
		return id;
	}

	public Responsabile getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(Responsabile responsabile) {
		this.responsabile = responsabile;
	}
	

}
