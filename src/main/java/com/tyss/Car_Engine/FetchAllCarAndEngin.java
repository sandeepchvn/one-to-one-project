package com.tyss.Car_Engine;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAllCarAndEngin {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	
	Query query=em.createQuery("select c from Car c");
	List<Car> li=query.getResultList();
	
	for(Car car:li) {
		System.out.println("----------------------CAR-------------------------");
		System.out.println("Car id "+car.getId());
		System.out.println("Car name "+car.getName());
		System.out.println("Car Price "+car.getPrice());
		System.out.println("---------------------ENGINE------------------------");
		Engine engine=car.getEngine();
		System.out.println("Engine id "+engine.getId());
		System.out.println("Engine type "+engine.getType());
		System.out.println("Engine CC "+engine.getCc());
	}
}
}
