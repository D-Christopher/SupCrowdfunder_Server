package com.supinfo.dao;

import java.util.List;

import com.supinfo.entity.Categorie;
import com.supinfo.entity.Projet;

public interface ProjetDao {
	public boolean createProjet(Projet projet);
	public List<Projet> getProjet(Categorie categorie);
	public boolean suprimerProjetById(int id);
	public Projet getProjetById(int id_projet);
	public boolean updateProjet(Projet projet);
}
