package com.ms.dao;

import java.util.List;
import java.util.function.Consumer;

import com.ms.Model.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee emp);
	
	public long totalEmployees();
	
	public List<Employee> getEmployee();
	
	public void updatePassword(int empId, String newPassword);
	
	public void deleteEmployeeRecord(int empId);
	
	public void getEmployeeAndAssetDetails(int empId);
}
