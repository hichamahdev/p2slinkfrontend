package com.example.equip.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "anneau")
public class Anneau {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String type;
	private String notes;

	
	@OneToMany()
	@JoinColumn(name= "anneau_id")
	private List<Equipement> equipements ;
	
	@OneToMany()
	@JoinColumn(name= "anneau_id")
	private List<site> sites ;
	
	public Anneau() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

	public List<site> getSites() {
		return sites;
	}

	public void setSites(List<site> sites) {
		this.sites = sites;
	}

	public Anneau(long id, String nom, String type, String notes, List<Equipement> equipements, List<site> sites) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.notes = notes;
		this.equipements = equipements;
		this.sites = sites;
	}
	
}
