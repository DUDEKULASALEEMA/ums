package org.jsp.ums;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelectAllApp 
{
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		Query q=em.createQuery("from User");
		List <User>ul=q.getResultList();
		for(User u:ul) {
			System.out.println(u);
		}
		
	}

}
