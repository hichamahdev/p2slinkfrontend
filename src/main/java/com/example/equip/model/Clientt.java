package com.example.equip.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.plaf.synth.Region;

@Entity
@Table(name = "client")
public class Clientt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomClient;
	private long reference;
	private String identifiant ;
	private String Adress1 ;
	private String Adress2 ;
	private String Adress3 ;
	
	private String departement;
	private long codePostale;
	private String ville ;
	private String Pays;
	@OneToMany()
	@JoinColumn(name= "client_id")
	private List<Servicee> service ;
	
	public List<Servicee> getService() {
		return service;
	}
	public void setService(List<Servicee> service) {
		this.service = service;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getReference() {
		return reference;
	}
	public void setReference(long reference) {
		this.reference = reference;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getAdress1() {
		return Adress1;
	}
	public void setAdress1(String adress1) {
		Adress1 = adress1;
	}
	public String getAdress2() {
		return Adress2;
	}
	public void setAdress2(String adress2) {
		Adress2 = adress2;
	}
	public String getAdress3() {
		return Adress3;
	}
	public void setAdress3(String adress3) {
		Adress3 = adress3;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public long getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(long codePostale) {
		this.codePostale = codePostale;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return Pays;
	}
	public void setPays(String pays) {
		Pays = pays;
	}
	
	
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Clientt(long reference, String identifiant, String adress1, String adress2, String adress3,
			String departement, long codePostale, String ville, String pays) {
		super();
		this.reference = reference;
		this.identifiant = identifiant;
		Adress1 = adress1;
		Adress2 = adress2;
		Adress3 = adress3;
		this.departement = departement;
		this.codePostale = codePostale;
		this.ville = ville;
		Pays = pays;
	}
	
	public Clientt() {
		
	}
	
	

}
