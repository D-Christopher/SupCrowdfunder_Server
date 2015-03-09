package com.supinfo.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.supinfo.dao.CategorieDao;
import com.supinfo.entity.Categorie;


public class JpaCategorieDao implements CategorieDao {
	
private EntityManagerFactory emf;
	
	public JpaCategorieDao(EntityManagerFactory emf) {
		// TODO Auto-generated constructor stub
		this.emf = emf;
	}

		@Override
		public Categorie getCategorieById(int id_categorie) {
			// TODO Auto-generated method stub
			EntityManager em = emf.createEntityManager();
			Categorie category = em.find(Categorie.class, id_categorie);
			if(category != null){
				return category;
			}
			return null;
		}
		
		public List<Categorie>getAllCategorie() {
			// TODO Auto-generated method stub
			EntityManager em = emf.createEntityManager();
			int result = 0;

				TypedQuery<Categorie> query = em.createQuery("SELECT a FROM Categorie a", Categorie.class);
				result = query.getMaxResults();
				emf.close();
				
				if(result > 0)
				{
					return query.getResultList();
				}
				return null;
			}
		
		public boolean suprimerCategorieById(int id) {
			// TODO Auto-generated method stub
			EntityManager em = emf.createEntityManager();
			Categorie categorie = em.find(Categorie.class, id);
			
			if(categorie != null){
				// remove product from DB
		    	EntityTransaction t = em.getTransaction();
		    	try {
		    		t.begin();
		    		em.remove(categorie);
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
		
		public boolean createCategorie(Categorie categorie) {
			// TODO Auto-generated method stub
			EntityManager em = emf.createEntityManager();
	    	EntityTransaction t = em.getTransaction();
	    	try {
	    		t.begin();
	    		em.persist(categorie);
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
