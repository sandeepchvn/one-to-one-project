package employee_salaryInfo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Salary_Info {
	@Id
	private int id;
	private double salary;
	private String currency;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
