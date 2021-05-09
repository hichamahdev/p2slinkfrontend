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
@Table(name = "attribut")
public class Attribut {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomtype;
	private String typevaleur;
	private int taille;
	private boolean valeurreq;
	private String pntattach;
	
	@OneToMany()
	@JoinColumn(name= "attribut_id")
	private List<Equipement> equipements ;
	
	@OneToMany()
	@JoinColumn(name= "attribut_id")
	private List<Clientt> clients ;
	
	@OneToMany()
	@JoinColumn(name= "attribut_id")
	private List<Servicee> services ;
	
	@OneToMany()
	@JoinColumn(name= "attribut_id")
	private List<region> regions ;
	
	@OneToMany()
	@JoinColumn(name= "attribut_id")
	private List<site> sites ;
	
	@OneToMany()
	@JoinColumn(name= "attribut_id")
	private List<Carte> cartes ;
	
	@OneToMany()
	@JoinColumn(name= "attribut_id")
	private List<Port> ports ;
	
	Attribut(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomtype() {
		return nomtype;
	}

	public void setNomtype(String nomtype) {
		this.nomtype = nomtype;
	}

	public String getTypevaleur() {
		return typevaleur;
	}

	public void setTypevaleur(String typevaleur) {
		this.typevaleur = typevaleur;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public boolean isValeurreq() {
		return valeurreq;
	}

	public void setValeurreq(boolean valeurreq) {
		this.valeurreq = valeurreq;
	}

	public String getPntattach() {
		return pntattach;
	}

	public void setPntattach(String pntattach) {
		this.pntattach = pntattach;
	}

	public List<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

	public List<Clientt> getClients() {
		return clients;
	}

	public void setClients(List<Clientt> clients) {
		this.clients = clients;
	}

	public List<Servicee> getServices() {
		return services;
	}

	public void setServices(List<Servicee> services) {
		this.services = services;
	}

	public List<region> getRegions() {
		return regions;
	}

	public void setRegions(List<region> regions) {
		this.regions = regions;
	}

	public List<site> getSites() {
		return sites;
	}

	public void setSites(List<site> sites) {
		this.sites = sites;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public List<Port> getPorts() {
		return ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

	public Attribut(String nomtype, String typevaleur, int taille, boolean valeurreq, String pntattach,
			List<Equipement> equipements, List<Clientt> clients, List<Servicee> services, List<region> regions,
			List<site> sites, List<Carte> cartes, List<Port> ports) {
		super();
		this.nomtype = nomtype;
		this.typevaleur = typevaleur;
		this.taille = taille;
		this.valeurreq = valeurreq;
		this.pntattach = pntattach;
		this.equipements = equipements;
		this.clients = clients;
		this.services = services;
		this.regions = regions;
		this.sites = sites;
		this.cartes = cartes;
		this.ports = ports;
	}
	
	
	
	
	
	
	
	
	

}
