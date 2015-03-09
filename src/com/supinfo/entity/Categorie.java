package com.supinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
public class Categorie {
	
	@Id
	@GeneratedValue
	private int id_categorie;
	private String nom_categorie;
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	public String getNom_categorie() {
		return nom_categorie;
	}
	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}

	
}
