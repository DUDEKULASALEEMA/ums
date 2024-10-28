package org.jsp.ums;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteApp 
{
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Id");
		int id=sc.nextInt();
		
		User user=em.find(User.class, id);
		if(user!=null) {
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.remove(user);
			et.commit();
			System.out.println("User deleted Sucessfully");
			
		}
		else {
			System.err.println("Invalid User Id");
		}
	}

}
