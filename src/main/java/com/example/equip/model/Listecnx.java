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
@Table(name = "listecnx")
public class Listecnx {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany()
	@JoinColumn(name= "port_id")
	private List<Typeport> typeporta ;
	
	@OneToMany()
	@JoinColumn(name= "port_id")
	private List<Typeport> typeportb ;
	
	Listecnx(){}

	public Listecnx(List<Typeport> typeporta, List<Typeport> typeportb) {
		super();
		this.typeporta = typeporta;
		this.typeportb = typeportb;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Typeport> getTypeporta() {
		return typeporta;
	}

	public void setTypeporta(List<Typeport> typeporta) {
		this.typeporta = typeporta;
	}

	public List<Typeport> getTypeportb() {
		return typeportb;
	}

	public void setTypeportb(List<Typeport> typeportb) {
		this.typeportb = typeportb;
	}
	
	
	
	

}
