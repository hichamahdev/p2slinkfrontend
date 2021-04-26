package com.example.equip.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="port")
public class Port {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nomPort;
	private String typePort;
	private String servicePort;
	private String puissancePort;
	
	
	@ManyToOne
	@JoinColumn(name= "carteid", insertable = false, updatable=false)
	private Carte carte;
	
	private long carteid;
	
	
	public long getCarteid() {
		return carteid;
	}
	public void setCarteid(long carteid) {
		this.carteid = carteid;
	}
	public Port() {}
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
	public Carte getCarte() {
		return carte;
	}
	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	public Port(String nomPort, String typePort, String servicePort, String puissancePort, Carte carte) {
		super();
		this.nomPort = nomPort;
		this.typePort = typePort;
		this.servicePort = servicePort;
		this.puissancePort = puissancePort;
		this.carte = carte;
	}
	
	
	
	
	
	

}
