package com.example.equip.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "equipements")
public class Equipement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String reference;
	private String nomSupEquip;
	private String nomEquip;
	private String categorieEquip;
	private Integer numbSlot;
	private Integer numeroSlotMin;
	private Integer numeroSlotFin;
	private String typeSlot;
	private Integer debitMax;
	
	
	
	
	@OneToMany()
	@JoinColumn(name= "equipementid")
	private List<Slot> slot; 
	
	public Equipement() {
		
		
	}
	
	
	
	
	public List<Slot> getSlot() {
		return slot;
	}




	public void setSlot(List<Slot> slot) {
		this.slot = slot;
	}
	@OneToMany(mappedBy= "equipementid",cascade=CascadeType.REMOVE)
	private List <PortEquip> portEquip; 
	
	@JsonManagedReference
	public List<PortEquip> getPortEquip() {
		return portEquip;
	}
	
	


	public String getReference() {
		return reference;
	}




	public void setReference(String reference) {
		this.reference = reference;
	}




	public void setPortEquip(List<PortEquip> portEquip) {
		this.portEquip = portEquip;
	}


	
	



	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomSupEquip() {
		return nomSupEquip;
	}
	public void setNomSupEquip(String nomSupEquip) {
		this.nomSupEquip = nomSupEquip;
	}
	public String getNomEquip() {
		return nomEquip;
	}
	public void setNomEquip(String nomEquip) {
		this.nomEquip = nomEquip;
	}
	public String getCategorieEquip() {
		return categorieEquip;
	}
	public void setCategorieEquip(String categorieEquip) {
		this.categorieEquip = categorieEquip;
	}
	public Integer getNumbSlot() {
		return numbSlot;
	}
	public void setNumbSlot(Integer numbSlot) {
		this.numbSlot = numbSlot;
	}
	public Integer getNumeroSlotMin() {
		return numeroSlotMin;
	}
	public void setNumeroSlotMin(Integer numeroSlotMin) {
		this.numeroSlotMin = numeroSlotMin;
	}
	public Integer getNumeroSlotFin() {
		return numeroSlotFin;
	}
	public void setNumeroSlotFin(Integer numeroSlotFin) {
		this.numeroSlotFin = numeroSlotFin;
	}
	public String getTypeSlot() {
		return typeSlot;
	}
	@Override
	public String toString() {
		return "Equipement [nomSupEquip=" + nomSupEquip + ", nomEquip=" + nomEquip + ", categorieEquip="
				+ categorieEquip + ", numbSlot=" + numbSlot + ", numeroSlotMin=" + numeroSlotMin + ", numeroSlotFin="
				+ numeroSlotFin + ", typeSlot=" + typeSlot + ", debitMax=" + debitMax + "]";
	}


	public void setTypeSlot(String typeSlot) {
		this.typeSlot = typeSlot;
	}
	public Integer getDebitMax() {
		return debitMax;
	}
	public void setDebitMax(Integer debitMax) {
		this.debitMax = debitMax;
	}
	public Equipement(String nomSupEquip, String nomEquip, String categorieEquip, Integer numbSlot,
			Integer numeroSlotMin, Integer numeroSlotFin, String typeSlot, Integer debitMax ,String reference) {
		super();
		this.nomSupEquip = nomSupEquip;
		this.nomEquip = nomEquip;
		this.categorieEquip = categorieEquip;
		this.numbSlot = numbSlot;
		this.numeroSlotMin = numeroSlotMin;
		this.numeroSlotFin = numeroSlotFin;
		this.typeSlot = typeSlot;
		this.debitMax = debitMax;
		this.reference = reference;
	}
	
}
	
	