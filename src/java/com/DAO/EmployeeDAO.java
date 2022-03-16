package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.models.EmployeeModel;

public class EmployeeDAO {
	
	private static final String getAllEmployee = "select e.employee_id, e.first_name, e.last_name, j.job_title, e.salary, d.department_name, l.street_address, l.city, c.country_name, r.region_name from employees e join departments d on e.department_id = d.department_id join locations l on d.location_id = l.location_id join countries c on l.country_id = c.country_id join regions r on c.region_id = r.region_id join jobs j on e.job_id = j.job_id where e.department_id <> 60 and e.department_id <> 90 and e.department_id <> 10";
//	private static final String insertEmployee = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
//	private static final String updateEmployee = "update employees set ";
	
	public EmployeeDAO() {
	}
	
	public ArrayList<EmployeeModel> getEmployeesList()
	{
		List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		
		try {
			Connection connection = DatabaseConnection.initliazeDatabase();
			
			PreparedStatement statement = connection.prepareStatement(getAllEmployee);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				Integer employee_id = resultSet.getInt("employee_id");
				String fname = resultSet.getString("first_name");
				String lname = resultSet.getString("last_name");
				String job = resultSet.getString("job_title");
				Integer salary = resultSet.getInt("salary");
				String department = resultSet.getString("department_name");
				String address = resultSet.getString("street_address") + ", " + resultSet.getString("city");
				String country = resultSet.getString("country_name");
				String region = resultSet.getString("region_name");
				
				employees.add(new EmployeeModel(employee_id, fname, lname, job, salary, department, address, country, region));
			}
			
			return (ArrayList<EmployeeModel>) employees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
