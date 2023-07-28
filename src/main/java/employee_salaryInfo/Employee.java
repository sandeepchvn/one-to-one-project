package employee_salaryInfo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private long phone;
	private String designation;
	@OneToOne
	private Salary_Info sal_info;

	public Salary_Info getSal_info() {
		return sal_info;
	}

	public void setSal_info(Salary_Info sal_info) {
		this.sal_info = sal_info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


}
