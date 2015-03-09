package com.supinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Don {
	
	@Id
	@GeneratedValue
	private int id_don;
	public int getId_don() {
		return id_don;
	}
	public int getPrix_don() {
		return prix_don;
	}
	public void setPrix_don(int prix_don) {
		this.prix_don = prix_don;
	}
	private int prix_don;
	
	
}
