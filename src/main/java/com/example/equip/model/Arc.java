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
@Table(name = "arc")
public class Arc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	
	@OneToMany()
	@JoinColumn(name= "arc_id")
	private List <region>region;
	
	@OneToMany()
	@JoinColumn(name= "arc_id")
	private List <Anneau> anneau ;
	
	@OneToMany()
	@JoinColumn(name= "arc_id")
	private List <Equipement> equipement;
	
	@OneToMany()
	@JoinColumn(name= "arc_id")
	private List <Slot> slot;
	
	@OneToMany()
	@JoinColumn(name= "arc_id")
	private List<Port> port;
	
	
	public Arc() {}


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


	public List<region> getRegion() {
		return region;
	}


	public void setRegion(List<region> region) {
		this.region = region;
	}


	public List<Anneau> getAnneau() {
		return anneau;
	}


	public void setAnneau(List<Anneau> anneau) {
		this.anneau = anneau;
	}


	public List<Equipement> getEquipement() {
		return equipement;
	}


	public void setEquipement(List<Equipement> equipement) {
		this.equipement = equipement;
	}


	public List<Slot> getSlot() {
		return slot;
	}


	public void setSlot(List<Slot> slot) {
		this.slot = slot;
	}


	public List<Port> getPort() {
		return port;
	}


	public void setPort(List<Port> port) {
		this.port = port;
	}


	public Arc(String nom, List<com.example.equip.model.region> region, List<Anneau> anneau,
			List<Equipement> equipement, List<Slot> slot, List<Port> port) {
		super();
		this.nom = nom;
		this.region = region;
		this.anneau = anneau;
		this.equipement = equipement;
		this.slot = slot;
		this.port = port;
	}
}
