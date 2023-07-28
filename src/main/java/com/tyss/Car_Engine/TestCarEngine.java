package com.tyss.Car_Engine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestCarEngine {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println(entityManager);
		Car car=new Car();
		car.setId(1);
		car.setName("lamborginni");
		car.setPrice(99999999999.3);
		
		Engine engine=new Engine();
		engine.setId(101);
		engine.setType("petrol");
		engine.setCc(1500);
		
		//engine is given to car
		car.setEngine(engine);
		
		entityTransaction.begin();
		entityManager.persist(car);
		entityManager.persist(engine);
		entityTransaction.commit();
	}
}
