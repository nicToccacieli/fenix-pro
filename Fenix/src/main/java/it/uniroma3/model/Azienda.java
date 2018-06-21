package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Azienda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String sedeLegale;
	
	@Column(nullable = false)
	private Long partitaIVA;
	
	@OneToMany
	@JoinColumn(name= "azienda_id")
	private List<Docente> docenti;
	
	@OneToMany
	@JoinColumn(name= "azienda_id")
	private List<Centro> centri;
	
	@OneToMany
	@JoinColumn(name= "azienda_id")
	private List<Responsabile> responsabili;
	

	@OneToMany
	@JoinColumn(name= "azienda_id")
	private List<Allievo> allievi;
	
	public Azienda(Long id, String nome, String sede, Long IVA) {
		this.id = id;
		this.nome = nome;
		this.sedeLegale = sede;
		this.partitaIVA = IVA;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSedeLegale() {
		return sedeLegale;
	}

	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}

	public Long getPartitaIVA() {
		return partitaIVA;
	}

	public void setPartitaIVA(Long partitaIVA) {
		this.partitaIVA = partitaIVA;
	}

	public Long getId() {
		return id;
	}

}
