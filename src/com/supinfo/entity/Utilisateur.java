package com.supinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
	
	@Id
	@GeneratedValue
	private int id_utilisateur;
	private String nom_utilisateur;
	private String prenom_utilisateur;
	private String mail_utilisateur;
	private String mdp_utilisateur;
	private boolean admin_utilisateur;
	
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public String getNom_utilisateur() {
		return nom_utilisateur;
	}
	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}
	public String getPrenom_utilisateur() {
		return prenom_utilisateur;
	}
	public void setPrenom_utilisateur(String prenom_utilisateur) {
		this.prenom_utilisateur = prenom_utilisateur;
	}
	public String getMail_utilisateur() {
		return mail_utilisateur;
	}
	public void setMail_utilisateur(String mail_utilisateur) {
		this.mail_utilisateur = mail_utilisateur;
	}
	public String getMdp_utilisateur() {
		return mdp_utilisateur;
	}
	public void setMdp_utilisateur(String mdp_utilisateur) {
		this.mdp_utilisateur = mdp_utilisateur;
	}
	public boolean isAdmin_utilisateur() {
		return admin_utilisateur;
	}
	public void setAdmin_utilisateur(boolean admin_utilisateur) {
		this.admin_utilisateur = admin_utilisateur;
	}
}
