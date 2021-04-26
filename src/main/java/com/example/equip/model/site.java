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
@Table(name = "site")
public class site {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String type;
	private String notes;
	
	@OneToMany()
	@JoinColumn(name= "site_id")
	private List<Equipement> equipement ;
	
	
	public List<Equipement> getEquipement() {
		return equipement;
	}
	public void setEquipement(List<Equipement> equipement) {
		this.equipement = equipement;
	}
	public site(){
		
	}
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
	public site(long id, String nom, String type, String notes) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.notes = notes;
	}
	
	
}
