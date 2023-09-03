package com.gl.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.gl.jdbc.model.Employee;
import com.gl.jdbc.myconnections.MyConnection;

public class EmployeeDao {
	
	Connection myCon;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	MyConnection mCon;
	public EmployeeDao()
	{
		mCon = new MyConnection();
	}
	
	public ArrayList <Employee> getEmployees()
	{
		
		myCon = mCon.getMyConnection();
		ArrayList <Employee> employees = new ArrayList<Employee>();
		try {
			String query = "select * from employees";
			stmt = myCon.createStatement();
			rs = stmt.executeQuery(query);
			String eId, eName, eAddr, ePhone;
			int eSal;
			float eTax;
			while(rs.next())
			{
				Employee employee = new Employee();
				eId = rs.getString(1);
				employee.setEmployeeId(eId);
				
				eName = rs.getString(2);
				employee.setEmployeeName(eName);
				
				eAddr = rs.getString(3);
				employee.setEmployeeAddress(eAddr);
				
				ePhone = rs.getString(4);
				employee.setEmployeePhone(ePhone);
				
				//employee.setEmployeePhone(rs.getString(4));
				
				eSal = rs.getInt(5);
				employee.setEmployeeSalary(eSal);
				
				eTax = rs.getFloat(6);
				employee.setProfTax(eTax);
				
				employees.add(employee);
				
				//employee = new Employee(eId,eName,eAddr,ePhone,eSal,eTax);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}


	public Employee getEmployeeById(String employeeId)
	{
		myCon = mCon.getMyConnection();
		Employee employee = new Employee();
		try {
			pstmt = myCon.prepareStatement("select * from Employees where employeeId = ?");
			pstmt.setString(1, employeeId);
			// select * from employees where employeeSalary > ? and employeeAddress = ?
			rs = pstmt.executeQuery();
			rs.next();
			String eId = rs.getString(1);
			String eName = rs.getString(2);
			String eAddr = rs.getString(3);
			String ePhone = rs.getString(4);
			int eSal = rs.getInt(5);
			float eTax = rs.getFloat(6);
			employee = new Employee(eId,eName,eAddr,ePhone,eSal,eTax);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	public boolean insertEmployee(Employee employee)
	{
		boolean flag = false;
		myCon = mCon.getMyConnection();
		String query = "insert into employees value(?,?,?,?,?,?)";
		try {
			pstmt = myCon.prepareStatement(query);
			pstmt.setString(1, employee.getEmployeeId());
			pstmt.setString(2, employee.getEmployeeName());
			pstmt.setString(3, employee.getEmployeeAddress());
			pstmt.setString(4, employee.getEmployeePhone());
			pstmt.setInt(5, employee.getEmployeeSalary());
			pstmt.setDouble(6, employee.getProfTax());
			
			pstmt.execute();
			flag = true;
												
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean updateEmployee(Employee employee)
	{
		boolean flag = false;
		myCon = mCon.getMyConnection();
		String query = "update Employees set employeeAddress = ? where employeeId = ?";
		try {
			pstmt = myCon.prepareStatement(query);
			pstmt.setString(1, employee.getEmployeeAddress());
			pstmt.setString(2, employee.getEmployeeId());
			
			pstmt.execute();
			flag = true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false; 
		}
		return flag;
	}
	public boolean deleteEmployeeById(String employeeId)
	{
		boolean flag = false;
		myCon = mCon.getMyConnection();
		String query = "delete from Employee where employeeId = ?";
		try {
			PreparedStatement pstmt = myCon.prepareStatement(query);
			pstmt.setString(1, employeeId);
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
}

		
		

