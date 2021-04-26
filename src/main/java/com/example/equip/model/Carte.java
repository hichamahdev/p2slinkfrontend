package com.example.equip.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="carte")
public class Carte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomCarte;
	private String typeCarte;
	
	
	
	@OneToMany(mappedBy= "carteid",cascade=CascadeType.REMOVE)
	private List <Port> port;
	
	@JsonManagedReference
	public List<Port> getPort() {
		return port;
	}

	







	public void setPort(List<Port> port) {
		this.port = port;
	}
	public Carte() {}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomCarte() {
		return nomCarte;
	}
	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}
	public String getTypeCarte() {
		return typeCarte;
	}
	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}
	
	public Carte(String nomCarte, String typeCarte) {
		super();
		this.nomCarte = nomCarte;
		this.typeCarte = typeCarte;
		
	}

	
	
	
	
	
	
	

}
