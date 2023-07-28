package com.tyss.Car_Engine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.person_pan.dto.Person;

public class TestCreate {
	public static void main(String[] args) {
		EntityManagerFactory emEntityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager emManager = emEntityManagerFactory.createEntityManager();
		System.out.println("Table is created");
	}
}
