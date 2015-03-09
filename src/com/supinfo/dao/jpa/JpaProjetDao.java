package com.supinfo.dao.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.supinfo.dao.ProjetDao;
import com.supinfo.entity.Categorie;
import com.supinfo.entity.Projet;



public class JpaProjetDao implements ProjetDao{

	
	private EntityManagerFactory emf;
	
	public JpaProjetDao(EntityManagerFactory emf) {
		// TODO Auto-generated constructor stub
		this.emf = emf;
	}
	
	public boolean createProjet(Projet projet) {
		// TODO Auto-generated method stub
		// add projet to DB
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction t = em.getTransaction();
    	try {
    		t.begin();
    		em.persist(projet);
    		t.commit();
    		return true;
    	} catch (Exception e) {
    	// TODO: handle exception
    		return false;
    	} finally {
    		if (t.isActive()) t.rollback();
    		em.close();
    		emf.close();
    	}
	}
	
	public boolean suprimerProjetById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Projet projet = em.find(Projet.class, id);
		
		if(projet != null){
			// remove product from DB
	    	EntityTransaction t = em.getTransaction();
	    	try {
	    		t.begin();
	    		em.remove(projet);
	    		t.commit();
	    		return true;
	    	} catch (Exception e) {
	    	// TODO: handle exception
	    		return false;
	    	} finally {
	    		if (t.isActive()) t.rollback();
	    		em.close();
	    		emf.close();
	    	}
		}
		return false;
	}
	
	public List<Projet>getProjet(Categorie categorie) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		int result = 0;
		//System.out.println(id_categorie);
		if(categorie.getId_categorie() == 0)
		{
			
			TypedQuery<Projet> query = em.createQuery("SELECT a FROM Projet a", Projet.class);
			result = query.getMaxResults();
			emf.close();
			
			if(result > 0)
			{
				return query.getResultList();
			}
			return null;
		}
		else
		{
			TypedQuery<Projet> query = em.createQuery("SELECT a FROM Projet a WHERE id_categorie=" + categorie.getId_categorie() + "", Projet.class);
			//Query query = em.createQuery(SELECT_BY_CATEGORIE);
			//query.setParameter(PARAM_CATEGORIE, id_categorie);
			result = query.getMaxResults();
			emf.close();
			
			if(result > 0)
			{
				return query.getResultList();
			}
			return null;
		}
		
		
	}

	@Override
	public Projet getProjetById(int id_projet) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Projet projet = em.find(Projet.class, id_projet);
		if(projet != null){
			return projet;
		}
		return null;
	}

	public boolean updateProjet(Projet projet){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
    	try {
    		t.begin();
    		em.merge(projet);
    		t.commit();
    		return true;
    	} catch (Exception e) {
    	// TODO: handle exception
    		return false;
    	} finally {
    		if (t.isActive()) t.rollback();
    		em.close();
    		emf.close();
    	}
}



}
