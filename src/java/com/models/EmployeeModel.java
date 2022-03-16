package com.models;

public class EmployeeModel {
	int employee_id;
	String firstname;
	String lastname;
	String job;
	int salary;
	String department;
	String location;
	String country;
	String region;
	
	public EmployeeModel(
			int employee_id,
			String firstname,
			String lastname,
			String job,
			int salary,
			String department,
			String location,
			String country,
			String region
			) 
	{
		this.employee_id = employee_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.job = job;
		this.salary = salary;
		this.department = department;
		this.location = location;
		this.country = country;
		this.region = region;
	}
	
	public EmployeeModel() {
	}
	
	public void setEmpID(int employee_id)
	{
		this.employee_id = employee_id;
	}
	public int getEmpID()
	{
		return employee_id;
	}
	
	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	public int getSalary()
	{
		return salary;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	public String getFirstname()
	{
		return firstname;
	}
	
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	public String getLastname()
	{
		return lastname;
	}
	
	public void setJob(String job)
	{
		this.job = job;
	}
	public String getJob()
	{
		return job;
	}
	
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public String getDepartment()
	{
		return department;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	public String getLocation()
	{
		return location;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	public String getCountry()
	{
		return country;
	}
	
	public void setRegion(String region)
	{
		this.region = region;
	}
	public String getRegion()
	{
		return region;
	}
	
	public void display() {
		System.out.println(employee_id);
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(job);
		System.out.println(salary);
		System.out.println(department);
		System.out.println(location);
		System.out.println(country);
		System.out.println(region);
	}
}
