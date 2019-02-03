package in.ac.adit.JDBCDemo2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAOimpl implements EmployeeDAO{
	private Connection connection;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
	
	public EmployeeDAOimpl() {
		try {
			Class.forName(Driver);
			connection = DriverManager.getConnection(url,username,password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean createEmployee(Employee emp) {
		try {
			pst = connection.prepareStatement("insert into Employee_Info values(?,?,?,?)");
			
			pst.setString(1, emp.getEmployeeId());
			pst.setString(2, emp.getEmployeeName());
			pst.setString(3, emp.getEmployeeAddress());
			pst.setDouble(4, emp.getEmployeeSalary());
			
			pst.executeUpdate();
			
			System.out.println("Employee Created.");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	
	public int updateEmployee(String E_id,double E_Salary) {
		int count=0;
		try {
			pst = connection.prepareStatement("update Employee_Info set E_Salary = ? where E_id= ? ");
			
			pst.setDouble(1, E_Salary);
			pst.setString(2, E_id);
			
			count= pst.executeUpdate();
			
			
			System.out.println(count+"Employee updated");
			
			return count;
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			
			List<Employee> emplist = new ArrayList<Employee>();
			pst = connection.prepareStatement("select * from Employee_Info");
			rs= pst.executeQuery();
			while(rs.next()) {
				Employee e = new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
				emplist.add(e);
			}
			return emplist;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}

	@Override
	public boolean deleteEmployee(String E_id) {
		int count=0;
		try {
			pst = connection.prepareStatement("delete from Employee_Info where E_id=?");
			pst.setString(1,E_id);
			count=pst.executeUpdate();
			System.out.println(count+"row deleted");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Employee getEmployee(String E_id) {
		try {
			pst = connection.prepareStatement("select * from Employee_Info where E_id = ?");
			pst.setString(1, E_id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			}
			else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
