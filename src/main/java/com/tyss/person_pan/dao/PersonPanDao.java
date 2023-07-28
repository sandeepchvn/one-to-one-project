package com.tyss.person_pan.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.person_pan.dto.PanCard;
import com.tyss.person_pan.dto.Person;

public class PersonPanDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Scanner sc = new Scanner(System.in);

	public void savePersonAndPan() {
		Person person = new Person();
		System.out.println("enter the Person id");
		person.setId(sc.nextInt());
		System.out.println("enter the Person name");
		person.setName(sc.next());
		System.out.println("enter the Person address");
		person.setAddress(sc.next());
		System.out.println("enter the Person phone");
		person.setPhone(sc.nextLong());
		PanCard pan=new PanCard();
		System.out.println("enter the Pan card id");
		pan.setId(sc.nextInt());
		System.out.println("enter the Pan Number");
		pan.setPanNumber(sc.next());
		System.out.println("enter Full name");
		pan.setFullName(sc.next());
		System.out.println("enter Permanent address");
		pan.setPermanentAddress(sc.next());
		person.setPan(pan);
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(pan);
		entityTransaction.commit();
		System.out.println("saved !-----");
	}

	public void deletePerson() {
		System.out.println("enter id to delete the Person");
		Person person = entityManager.find(Person.class, sc.nextInt());
		if (person != null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
		}
		else
			System.err.println("id is wrong");
	}
	public void updatePerson() {
		System.out.println("enter id to update the address");
		Person person = entityManager.find(Person.class, sc.nextInt());
		if (person != null) {
			person.setAddress(sc.next());
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
		}
		else
			System.err.println("id is wrong");
	}
	public void findPerson() {
		System.out.println("enter id to find the person");
		Person person = entityManager.find(Person.class, sc.nextInt());
		if (person != null) {
			System.out.println("Id "+person.getId());
			System.out.println("Name "+person.getName());
			System.out.println("Address "+person.getAddress());
			System.out.println("Phone "+person.getPhone());
			//PanCard pan=new  PanCard();
			PanCard pan=person.getPan();
			System.out.println("----------------------------------------");
			System.out.println("Pan Id "+pan.getId());
			System.out.println("Pan Number "+pan.getPanNumber());
			System.out.println("Pan Full NAme "+pan.getFullName());
			System.out.println("Pan Permanent Adress "+pan.getPermanentAddress());
		}
		else
			System.err.println("id is wrong");
	}
}
