package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.models.EmployeeModel;

public class LoginDAO {
	
	String query = "select * from employees where department_id=? and employee_id=?";
	String getName = "select e.employee_id, e.first_name, e.last_name, j.job_title, e.salary, d.department_name, l.street_address, l.city, c.country_name, r.region_name from employees e join departments d on e.department_id = d.department_id join locations l on d.location_id = l.location_id join countries c on l.country_id = c.country_id join regions r on c.region_id = r.region_id join jobs j on e.job_id = j.job_id where e.department_id = ? and e.employee_id = ?";
	
	public boolean checkCredential(int jobid, int empid)
	{
		try 
		{
			Connection connection = DatabaseConnection.initliazeDatabase();
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, jobid);
			statement.setInt(2, empid);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next())
			{
				return true;
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public EmployeeModel getDetails(int jobid, int employee_id) 
	{
		
		try {
			Connection connection = DatabaseConnection.initliazeDatabase();
			
			PreparedStatement statement = connection.prepareStatement(getName);
			statement.setInt(1, jobid);
			statement.setInt(2, employee_id);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Integer empid = resultSet.getInt("employee_id");
				String fname = resultSet.getString("first_name");
				String lname = resultSet.getString("last_name");
				String job = resultSet.getString("job_title");
				Integer salary = resultSet.getInt("salary");
				String department = resultSet.getString("department_name");
				String address = resultSet.getString("street_address") + ", " + resultSet.getString("city");
				String country = resultSet.getString("country_name");
				String region = resultSet.getString("region_name");
				EmployeeModel employeeModel = new EmployeeModel(empid, fname, lname, job, salary, department, address, country, region);
				employeeModel.display();
				return (new EmployeeModel(empid, fname, lname, job, salary, department, address, country, region));
			}
		} catch (Exception e) {
		}
		return null;
	}
}
