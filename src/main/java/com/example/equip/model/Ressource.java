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
@Table(name = "ressource")
public class Ressource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private int nombre;
	private String type;
	private String  point_att ;
	
	@OneToMany()
	@JoinColumn(name= "ressource_id")
	private List<Equipement> equipements ;
	
	@OneToMany()
	@JoinColumn(name= "ressource_id")
	private List<Servicee> services ;
	
	@OneToMany()
	@JoinColumn(name= "ressource_id")
	private List<Carte> cartes ;

	public Ressource() {}

	public Ressource(String nom, int nombre, String type, String point_att, List<Equipement> equipements,
			List<Servicee> services, List<Carte> cartes) {
		super();
		this.nom = nom;
		this.nombre = nombre;
		this.type = type;
		this.point_att = point_att;
		this.equipements = equipements;
		this.services = services;
		this.cartes = cartes;
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

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPoint_att() {
		return point_att;
	}

	public void setPoint_att(String point_att) {
		this.point_att = point_att;
	}

	public List<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

	public List<Servicee> getServices() {
		return services;
	}

	public void setServices(List<Servicee> services) {
		this.services = services;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}
	
	
	
	
	

}
