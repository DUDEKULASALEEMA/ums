package org.jsp.ums;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertApp 
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name");
		String name=sc.next();
		
		System.out.println("Enter the UserName");
		String username=sc.next();
		
		System.out.println("Enter Email");
		String email=sc.next();
		
		System.out.println("Enter Phone Number");
		long phone=sc.nextLong();
		
		System.out.println("Enter Password");
		String password=sc.next();
		
		
		User u=new User(0,name,username,email,phone,password);
		EntityTransaction et =em.getTransaction();
		et.begin();
		em.persist(u);
		et.commit();
		System.out.println("Inserted Sucessfully");
		
		
		
		
	}

	

}
