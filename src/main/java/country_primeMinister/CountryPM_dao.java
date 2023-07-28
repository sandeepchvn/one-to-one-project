package country_primeMinister;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class CountryPM_dao {
	private Scanner sc = new Scanner(System.in);
	EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void save() {
		System.out.println("enter country id\nName\nNumber of States");
		Country country = new Country();
		country.setId(sc.nextInt());
		country.setName(sc.next());
		country.setNoOfState(sc.nextInt());
		System.out.println("enter PM id\nName\nParty");
		PrimeMinister pm = new PrimeMinister();
		pm.setId(sc.nextInt());
		pm.setName(sc.next());
		pm.setParty(sc.next());

		country.setPm(pm);

		et.begin();
		em.persist(country);
		em.persist(pm);
		et.commit();
		System.out.println("saved------!");

	}
	public void delete() {
		System.out.println("enter the country id to delete the country");
		Country c=em.find(Country.class, sc.nextInt());
		if(c != null) {
			et.begin();
			em.remove(c);
			et.commit();
			System.out.println("deleted----!");
		}
		else 
			System.out.println("id is wrong ---!");
	}
	public void findCountry() {
		System.out.println("enter the country id to find the country");
		Country c=em.find(Country.class, sc.nextInt());
		PrimeMinister pm=c.getPm();
		if(c != null) {
			System.out.println(c.getId());
			System.out.println(c.getName());
			System.out.println(c.getNoOfState());
			System.out.println(pm.getId());
			System.out.println(pm.getName());
			System.out.println(pm.getParty());
		}
		else 
			System.out.println("id is wrong ---!");
	}
	public void update() {
		System.out.println("enter the country id to update the Prime Minister");
		Country c=em.find(Country.class, sc.nextInt());
		PrimeMinister pm=c.getPm();
		System.out.println("enter th PM name");
		pm.setName(sc.next());
		if(c != null) {
			et.begin();
			em.merge(pm);
			et.commit();
			System.out.println("Updated----!");
		}
		else 
			System.out.println("id is wrong ---!");
	}
	public void findAll() {
		Query query=em.createQuery("select c from Country c");
	List<Country> 	countries=query.getResultList();
	for(Country c:countries) {
		System.out.println(c.getId());
		System.out.println(c.getName());
		System.out.println(c.getNoOfState());
		PrimeMinister pm=c.getPm();
		System.out.println(pm.getId());
		System.out.println(pm.getName());
		System.out.println(pm.getParty());
	}
	}
}
