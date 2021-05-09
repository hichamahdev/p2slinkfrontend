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
	private int numberPort;
	private long slot_id ;
	
	
	
	@OneToMany()
	@JoinColumn(name= "carteid")
	private List <Port> port;
	
	public int getNumberPort() {
		return numberPort;
	}

	public void setNumberPort(int numberPort) {
		this.numberPort = numberPort;
	}

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
	
	public long getSlot_id() {
		return slot_id;
	}

	public void setSlot_id(long slot_id) {
		this.slot_id = slot_id;
	}

	public Carte(String nomCarte, String typeCarte,int numberPort) {
		super();
		this.nomCarte = nomCarte;
		this.typeCarte = typeCarte;
		this.numberPort = numberPort;
		
	}

	
	
	
	

}
