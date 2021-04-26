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
@Table(name = "region")
public class region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String note;
	
	@OneToMany()
	@JoinColumn(name= "region_id")
	private List<site> site ;
	
	public region() {
		
	}
	public region(long id, String nom, String note, List<com.example.equip.model.site> site) {
		super();
		this.id = id;
		this.nom = nom;
		this.note = note;
		this.site = site;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<site> getSite() {
		return site;
	}
	public void setSite(List<site> site) {
		this.site = site;
	}
	
	

}
