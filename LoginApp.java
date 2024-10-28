package org.jsp.ums;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LoginApp 
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter UserName:");
		String username=sc.next();
		System.out.println("Enter Password:");
		String password =sc.next();
		//Query q=em.createQuery("select u from User u where u.username=:un and u.password=:pwd");
		Query q=em.createQuery("select u from User u where u.username=?1 and u.password=?2");

		//q.setParameter("un", username);
		//q.setParameter("pwd", password);
		

		q.setParameter(1, username);
		q.setParameter(2, password);
		User user=(User) q.getSingleResult();
		System.out.println(user);
		
	}

}
