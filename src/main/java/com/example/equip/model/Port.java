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
@Table(name="port")
public class Port {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nomPort;
	private String servicePort;
	private String puissancePort;
	
	@OneToMany()
	@JoinColumn(name= "port_id")
	private List<Typeport> typeport ;
		
	
		
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
	
	public Port(String nomPort, String servicePort, String puissancePort, Carte carte) {
		super();
		this.nomPort = nomPort;
		
		this.servicePort = servicePort;
		this.puissancePort = puissancePort;
		
	}

	public List<Typeport> getTypeport() {
		return typeport;
	}

	public void setTypeport(List<Typeport> typeport) {
		this.typeport = typeport;
	}
	
	


}
