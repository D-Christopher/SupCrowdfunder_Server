package com.supinfo.dao;

import java.util.List;

import com.supinfo.entity.Categorie;
	
public interface CategorieDao {
	public Categorie getCategorieById(int id_categorie);
	public List<Categorie>getAllCategorie();
	public boolean suprimerCategorieById(int id);
	public boolean createCategorie(Categorie categorie);
}



