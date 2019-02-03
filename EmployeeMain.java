package in.ac.adit.JDBCDemo2;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee emp=new Employee("00001","Vatsal","Anand",3600.00); 
		Employee emp1=new Employee("00002","Meet","Junagadh",32000.00); 
		//emp = new Employee("00002","Raj","Rajkot",32000.00);
		
		EmployeeDAOimpl edi = new EmployeeDAOimpl();
		//Create Employee
		edi.createEmployee(emp);
		edi.createEmployee(emp1);

		//Update Employee
		edi.updateEmployee("00001", 40000.50);
		
		//GetAllEmployees
		for(int i =0;i<edi.getAllEmployees().size();i++) {
			edi.getAllEmployees().get(i).Display();
		}
		
		//Delete Employee
		edi.deleteEmployee("00002");
		
		//GetEmployee
		edi.getEmployee("00001").Display();
	}

}
