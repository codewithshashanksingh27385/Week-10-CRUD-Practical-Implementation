package com.gl.jdbc.meta;

import java.sql.Connection;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.gl.jdbc.myconnections.MyConnection;

public class SampleMetaData {
			
	MyConnection mycon;
	public SampleMetaData()
	{
		mycon = new MyConnection();
	}
	
	public void getDatabaseMetaDataInfo()
	{
		Connection con = mycon.getMyConnection();
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("Database Product Name:" +dbmd.getDatabaseProductName());
			System.out.println("Database Product Version:" +dbmd.getDatabaseProductVersion());
			System.out.println("Database Major Version:" +dbmd.getDatabaseMajorVersion());
			System.out.println("Database Minor Version:" +dbmd.getDatabaseMinorVersion());
			
			System.out.println("Driver Name:" +dbmd.getDriverName());
			System.out.println("Driver Version:" +dbmd.getDriverVersion());
			System.out.println("Driver Major Version :" +dbmd.getDriverMajorVersion());
			System.out.println("Driver Minor Version :" +dbmd.getDriverMinorVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getDatabaseMetaDataInfo1()
	{
		Connection con = mycon.getMyConnection();
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getTables(null, null, null, null);
		   System.out.println("The Tables Present are");
		   
			While(rs.next())
		    
		     {
		    	 System.out.println(rs.getString(3));
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void While(boolean next) {
		// TODO Auto-generated method stub
		
	}

	public void getResultSetMetaDataInfo()
	{
		Connection con = mycon.getMyConnection();
		String query = "select * from employees";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("the Column info");
			System.out.println("Column Count :"+rsmd.getColumnCount());
			System.out.println("Column Label of 1st Column :"+rsmd.getColumnLabel(1));
			System.out.println("Column Name of 1st Column :"+rsmd.getColumnName(1));
			System.out.println("Column Type of 1st Column :"+rsmd.getColumnType(1));
			System.out.println("Column TypeName of 1st Column :"+rsmd.getColumnTypeName(1));
			
			System.out.println("Column Count :"+rsmd.getColumnCount());
			System.out.println("ColumnLabel of 2nd Column :"+rsmd.getColumnLabel(2));
			System.out.println("Column Name of 2nd Column :"+rsmd.getColumnName(2));
			System.out.println("Column Type of 2nd Column :"+rsmd.getColumnType(2));
			System.out.println("Column TypeName of 2nd Column :"+rsmd.getColumnTypeName(2));
			
			
			System.out.println("ColumnLabel of 5th Column :"+rsmd.getColumnLabel(5));
			System.out.println("Column Name of 5th Column :"+rsmd.getColumnName(5));
			System.out.println("Column Type of 5th Column :"+rsmd.getColumnType(5));
			System.out.println("Column TypeName of 5th Column :"+rsmd.getColumnTypeName(5));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public static void main(String[] args)
	{
		SampleMetaData smd = new SampleMetaData();
		System.out.println("Database Info");
		
		smd.getDatabaseMetaDataInfo();
		System.out.println("---------------------");
		System.out.println("Tables Present ");
		smd.getDatabaseMetaDataInfo1();
		System.out.println("---------RESULTSET METADATA---------");
		smd.getResultSetMetaDataInfo();
		
	}
}
