package com.supinfo.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.supinfo.dao.UtilisateurDao;
import com.supinfo.entity.Utilisateur;

public class JpaUtilisateurDao implements UtilisateurDao {
	
	
	private EntityManagerFactory emf;
	
	public JpaUtilisateurDao(EntityManagerFactory emf) {
		// TODO Auto-generated constructor stub
		this.emf = emf;
	}


	@Override
	public Utilisateur getUtilisateurById(int id_utilisateur) {
	
		EntityManager em = emf.createEntityManager();
		Utilisateur utilisateur = em.find(Utilisateur.class, id_utilisateur);
		if(utilisateur != null){
			return utilisateur;
		}
		return null;
	}


	public boolean createUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
    	EntityTransaction t = em.getTransaction();
    	try {
    		t.begin();
    		em.persist(utilisateur);
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
	
	public Utilisateur getUtilisateurByMail(String mail) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		TypedQuery<Utilisateur> query = em.createQuery("SELECT a FROM Utilisateur a WHERE a.mail_utilisateur='" + mail + "'", Utilisateur.class);
		
		if(!query.getResultList().isEmpty())
		{
			return query.getSingleResult();
		}
		
		emf.close();
		return null;
	}
	
	public List<Utilisateur>getAllUtilisateur() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		int result = 0;

			TypedQuery<Utilisateur> query = em.createQuery("SELECT a FROM Utilisateur a", Utilisateur.class);
			result = query.getMaxResults();
			emf.close();
			
			if(result > 0)
			{
				return query.getResultList();
			}
			return null;
		}

	public boolean suprimerUtilisateurById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		
		if(utilisateur != null){
			// remove product from DB
	    	EntityTransaction t = em.getTransaction();
	    	try {
	    		t.begin();
	    		em.remove(utilisateur);
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
	
	public boolean updateUtilisateur(Utilisateur utilisateur){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
    	try {
    		t.begin();
    		em.merge(utilisateur);
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
