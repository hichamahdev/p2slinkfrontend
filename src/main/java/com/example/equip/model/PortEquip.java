package com.example.equip.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="portEquip")
public class PortEquip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nomPort;
	private String typePort;
	private String servicePort;
	private String puissancePort;
	
	
	@ManyToOne
	@JoinColumn(name= "equipementid", insertable = false, updatable=false)
	private Equipement equipement;
	
	private long equipementid;
	
	public PortEquip() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomPort() {
		return nomPort;
	}

	public void setNomPort(String nomPort) {
		this.nomPort = nomPort;
	}

	public String getTypePort() {
		return typePort;
	}

	public void setTypePort(String typePort) {
		this.typePort = typePort;
	}

	public String getServicePort() {
		return servicePort;
	}

	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}

	public String getPuissancePort() {
		return puissancePort;
	}

	public void setPuissancePort(String puissancePort) {
		this.puissancePort = puissancePort;
	}
	
	@JsonBackReference
	public Equipement getEquipement() {
		return equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

	public long getEquipementid() {
		return equipementid;
	}

	public void setEquipementid(long equipementid) {
		this.equipementid = equipementid;
	}

	public PortEquip(String nomPort, String typePort, String servicePort, String puissancePort, Equipement equipement
			) {
		super();
		this.nomPort = nomPort;
		this.typePort = typePort;
		this.servicePort = servicePort;
		this.puissancePort = puissancePort;
		this.equipement = equipement;
		
	}
	

}
