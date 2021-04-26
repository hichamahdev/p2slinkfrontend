package com.example.equip.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "slot")
public class Slot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Integer numeroSlot;
	private String nomSlot;
	private String typeslot;
	private Integer slotMin;
	private Integer slotFin;
	private long equipement_id;
	@OneToOne()
	@JoinColumn(name= "slot_id")
	private Carte  carte;
	
	


	
	


	public long getEquipement_id() {
		return equipement_id;
	}

	public void setEquipement_id(long equipement_id) {
		this.equipement_id = equipement_id;
	}

	public Integer getSlotMin() {
		return slotMin;
	}

	public void setSlotMin(Integer slotMin) {
		this.slotMin = slotMin;
	}

	public Integer getSlotFin() {
		return slotFin;
	}

	public void setSlotFin(Integer slotFin) {
		this.slotFin = slotFin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getNumeroSlot() {
		return numeroSlot;
	}

	public void setNumeroSlot(Integer numeroSlot) {
		this.numeroSlot = numeroSlot;
	}

	public String getNomSlot() {
		return nomSlot;
	}

	public void setNomSlot(String nomSlot) {
		this.nomSlot = nomSlot;
	}

	public String getTypeslot() {
		return typeslot;
	}

	public void setTypeslot(String typeslot) {
		this.typeslot = typeslot;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public Slot(long id, Integer numeroSlot, String nomSlot, String typeslot, Carte carte) {
		super();
		this.id = id;
		this.numeroSlot = numeroSlot;
		this.nomSlot = nomSlot;
		this.typeslot = typeslot;
		this.carte = carte;
	}
	
	public Slot() {}
	

}
