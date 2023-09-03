package com.gl.jdbc.service;

import java.util.ArrayList;

import com.gl.jdbc.dao.EmployeeDao;
import com.gl.jdbc.model.Employee;

public class EmployeeService {
	
	EmployeeDao eDao;
	public EmployeeService()
	{
		eDao = new EmployeeDao();
		
	}
	
	public ArrayList <Employee> getEmployeesSvc()
	{
		return eDao.getEmployees();
	}
	public Employee getEmployeebyId(String eId)
	{
		return eDao.getEmployeeById(eId);
	}
	public boolean insertEmployeeSvc(Employee employee)
	{
		return eDao.insertEmployee(employee);
	}
	
	public boolean updateEmployeeSvc(Employee employee)
	{
		return eDao.updateEmployee(employee);
	}
	public boolean deleteEmployeeByIdSvc(String employeeId)
	{
		return eDao.deleteEmployeeById(employeeId);
	}
}
