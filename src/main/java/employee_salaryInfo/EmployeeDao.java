package employee_salaryInfo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmployeeDao {
	private Scanner sc = new Scanner(System.in);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveEmployee() {
		Employee e = new Employee();
		System.out.println("enter Employee Id");
		e.setId(sc.nextInt());
		System.out.println("enter Employee Name");
		e.setName(sc.next());
		System.out.println("enter Employee Phone");
		e.setPhone(sc.nextLong());
		System.out.println("enter Employee Designation");
		e.setDesignation(sc.next());
		// adding salary info to Employee
		Salary_Info sal_info = new Salary_Info();
		System.out.println("enter salary id");
		sal_info.setId(sc.nextInt());
		System.out.println("enter the salary");
		sal_info.setSalary(sc.nextDouble());
		System.out.println("enter the currency");
		sal_info.setCurrency(sc.next());
		e.setSal_info(sal_info);

		et.begin();
		em.persist(e);
		em.persist(sal_info);
		et.commit();
		System.out.println("Employee and Salarty in saved");
	}

	public void delete() {
		System.out.println("enter the Employee Id to delete Employee");
		Employee e = em.find(Employee.class, sc.nextInt());
		Salary_Info sal_Inf=e.getSal_info();
		if (e != null) {
			et.begin();
			em.remove(e);
			em.remove(sal_Inf);
			et.commit();
			System.out.println("deleted--!");
		}else
			System.out.println("id is wrong---!");
	}
	public void updateEmployee() {
		System.out.println("enter the Employee Id to update Employee salary");
		Employee e = em.find(Employee.class, sc.nextInt());
		Salary_Info sal_Inf=e.getSal_info();
		System.out.println("enter the new Salary");
		sal_Inf.setSalary(sc.nextDouble());
		if (e != null) {
			et.begin();
			em.merge(sal_Inf);
			et.commit();
			System.out.println("updated--!");
		}else
			System.out.println("id is wrong---!");
	}
	public void findEmployee() {
		System.out.println("enter the Employee Id to find the Employee and salary information");
		Employee e=em.find(Employee.class, sc.nextInt());
		Salary_Info s=e.getSal_info();
		if(e != null) {
			System.out.println("Employee Id "+e.getId());
			System.out.println("Employee Name "+e.getName());
			System.out.println("Employee Phone "+e.getPhone());
			System.out.println("Employee Designation "+e.getDesignation());
			System.out.println("----------------------------------------");
			System.out.println("salary id "+s.getId());
			System.out.println("salary "+s.getSalary());
			System.out.println("currency "+s.getCurrency());
		}
	}
	public void findAll() {
		
		Query query=em.createQuery("Select e from Employee e");
		List<Employee> emps=query.getResultList();
	
		if(emps != null) {
			for(Employee e:emps) {
			System.out.println("Employee Id "+e.getId());
			System.out.println("Employee Name "+e.getName());
			System.out.println("Employee Phone "+e.getPhone());
			System.out.println("Employee Designation "+e.getDesignation());
			System.out.println("----------------------------------------");
			Salary_Info s=e.getSal_info();
			System.out.println("salary id "+s.getId());
			System.out.println("salary "+s.getSalary());
			System.out.println("currency "+s.getCurrency());
			}
		}
	}
}
