package com.supinfo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="projet")
public class Projet {
	
	@Id
	@GeneratedValue
	private int id_projet;
	private String titre_projet;
	private String description_projet;
	private String recompense_projet;
	private int argent_objectif_projet;
	private int argent_actuel_projet;
	private Date date_creation_projet;
	private Date date_limite_projet;
	
	@ManyToOne
	@JoinColumn(name = "id_categorie")
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	
	
	public int getId_projet() {
		return id_projet;
	}
	
	public String getTitre_projet() {
		return titre_projet;
	}
	public void setTitre_projet(String titre_projet) {
		this.titre_projet = titre_projet;
	}
	public String getDescription_projet() {
		return description_projet;
	}
	public void setDescription_projet(String description_projet) {
		this.description_projet = description_projet;
	}
	public String getRecompense_projet() {
		return recompense_projet;
	}
	public void setRecompense_projet(String recompense_projet) {
		this.recompense_projet = recompense_projet;
	}
	public int getArgent_objectif_projet() {
		return argent_objectif_projet;
	}
	public void setArgent_objectif_projet(int argent_objectif_projet) {
		this.argent_objectif_projet = argent_objectif_projet;
	}
	public int getArgent_actuel_projet() {
		return argent_actuel_projet;
	}
	public void setArgent_actuel_projet(int argent_actuel_projet) {
		this.argent_actuel_projet = argent_actuel_projet;
	}
	public Date getDate_creation_projet() {
		return date_creation_projet;
	}
	public void setDate_creation_projet(Date date_creation_projet) {
		this.date_creation_projet = date_creation_projet;
	}
	public Date getDate_limite_projet() {
		return date_limite_projet;
	}
	public void setDate_limite_projet(Date date_limite_projet) {
		this.date_limite_projet = date_limite_projet;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
