package employee_salaryInfo;

public class Controller {
	public static void main(String[] args) {
		EmployeeDao dao=new EmployeeDao();
		//dao.saveEmployee();
		//dao.delete();
		//dao.updateEmployee();
		dao.findAll();
	}
}
