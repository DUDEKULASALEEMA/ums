package org.jsp.ums;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static Scanner sc = new Scanner(System.in);

	static void login() {

		System.out.println("Enter UserName:");
		String username = sc.next();
		System.out.println("Enter Password:");
		String password = sc.next();
		Query q = em.createQuery("select u from User u where u.username=:un and u.password=:pwd");
		q.setParameter("un", username);
		q.setParameter("pwd", password);
		User user = (User) q.getSingleResult();
		System.out.println(user);

	}
	
	static void insertUser() {

		System.out.println("Enter name");
		String name = sc.next();

		System.out.println("Enter the UserName");
		String username = sc.next();

		System.out.println("Enter Email");
		String email = sc.next();

		System.out.println("Enter Phone Number");
		long phone = sc.nextLong();

		System.out.println("Enter Password");
		String password = sc.next();

		User u = new User(0, name, username, email, phone, password);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(u);
		et.commit();
		System.out.println("Inserted Sucessfully");

	}

	
	static void deleteById() {

		System.out.println("Enter Id");
		int id = sc.nextInt();

		User user = em.find(User.class, id);
		if (user != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(user);
			et.commit();
			System.out.println("User deleted Sucessfully");

		} else {
			System.err.println("Invalid User Id");
		}
	}

	
	static void selectAll() {

		Query q = em.createQuery("from User");
		List<User> ul = q.getResultList();
		for (User u : ul) {
			System.out.println(u);
		}

	}
	
	
	public static void main(String[] args) {
		while (true) {
			System.out.println("Select Options");
			System.out.println("1)Login");
			System.out.println("2)Create Account");
			System.out.println("3)Delete Account By Id");
			System.out.println("4)View All Accounts");
			System.out.println("5)Exit");
			switch (sc.nextInt()) {
			case 1:
				login();
				break;
			case 2:
				insertUser();
				break;
			case 3:
				deleteById();
				break;
			case 4:
				selectAll();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input");

			}

		}
	}

}
