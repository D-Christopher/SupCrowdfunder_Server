package com.supinfo.dao;

import com.supinfo.entity.Utilisateur;

public interface UtilisateurDao {
	
	public Utilisateur getUtilisateurById(int id_utilisateur);
	public Utilisateur getUtilisateurByMail(String mail_utilisateur);
	public boolean createUtilisateur(Utilisateur utilisateur);
	public boolean suprimerUtilisateurById(int id);
}
