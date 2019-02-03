package in.ac.adit.JDBCDemo2;
import java.util.List;

public interface EmployeeDAO {
	final String Driver = "com.mysql.jdbc.Driver";
	final String url = "jdbc:mysql://localhost:3306/Employee_Mgt";
	final String username = "root";
	final String password = "";
	
	public boolean createEmployee(Employee emp);
	
	public int updateEmployee(String E_id,double E_Salary);
	
	public List<Employee> getAllEmployees();
	
	public boolean deleteEmployee(String E_id);
	
	public Employee getEmployee(String E_id);

}
