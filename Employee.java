package in.ac.adit.JDBCDemo2;

public class Employee {
	public String E_id;
	public String E_Name;
	public String E_Address;
	public double E_Salary;
	
	public Employee(String E_id,String E_Name,String E_Address,double E_Salary) {
		this.E_id=E_id;
		this.E_Name= E_Name;
		this.E_Address = E_Address;
		this.E_Salary= E_Salary;
	}
	
	public void Display() {
		System.out.println(E_id+" "+E_Name+" "+E_Address+" "+E_Salary);
	}
	
	public String getEmployeeId() {
		return E_id;
	}
	public String getEmployeeName() {
		return E_Name;
	}
	public String getEmployeeAddress() {
		return E_Address;
	}
	public double getEmployeeSalary() {
		return E_Salary;
	}
}
