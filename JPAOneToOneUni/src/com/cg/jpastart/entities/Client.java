package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		//EntityManagerFactory is used create EntityManager instances
		//creates an EntityManagerFactory instance based on the persistance unit named "JPA-PU"
		//defined in 'persistence.xml' configuration file.
		EntityManager em = factory.createEntityManager();
		//EntityManager:interface used to interact with persistance context
		//it manages entity instances and their lifecycle
		em.getTransaction().begin();//starts new transaction
		
		Student student = new Student();
		student.setName("Deepak Patil");
		Address homeAddress = new Address();
		homeAddress.setStreet("MG Road");
		homeAddress.setCity("Pune");
		homeAddress.setState("Maharashtra");
		homeAddress.setZipCode("411 017");
		
		//inject address into student
		student.setAddress(homeAddress);
		
		//persist only student, no need to persist Address explicitly
		em.persist(student);
		//persists the student obj & cascades persistence operation to the associated address obj
		em.getTransaction().commit();
		//commits the transaction,making the changes permanent in database
		System.out.println("Added one student with address to database.");
		em.close(); //closes EntityManager
		factory.close();   //closes EntityManagerFactory 
	}
}
