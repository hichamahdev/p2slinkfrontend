package com.example.equip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class Servicee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long reference;
	private String nomService;
	private String typeService;
	private String idetinfiantServ;
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
	public String getNomService() {
		return nomService;
	}
	public void setNomService(String nomService) {
		this.nomService = nomService;
	}
	public String getTypeService() {
		return typeService;
	}
	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}
	public String getIdetinfiantServ() {
		return idetinfiantServ;
	}
	public void setIdetinfiantServ(String idetinfiantServ) {
		this.idetinfiantServ = idetinfiantServ;
	}
	public Servicee(long id, long reference, String nomService, String typeService, String idetinfiantServ) {
		super();
		this.id = id;
		this.reference = reference;
		this.nomService = nomService;
		this.typeService = typeService;
		this.idetinfiantServ = idetinfiantServ;
	}
	
	
	public Servicee() {}
	
	
	

}
