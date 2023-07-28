package com.tyss.Car_Engine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchingCarAndEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		
		Car car=em.find(Car.class, 1);
		System.out.println("---------------------------------------------------");
		System.out.println("Car id "+car.getId());
		System.out.println("Car name "+car.getName());
		System.out.println("Car Price "+car.getPrice());
		
		System.out.println("---------------------------------------------------");
		Engine engine=car.getEngine();
		System.out.println("Engine id "+engine.getId());
		System.out.println("Engine type "+engine.getType());
		System.out.println("Engine CC "+engine.getCc());
	}
}

