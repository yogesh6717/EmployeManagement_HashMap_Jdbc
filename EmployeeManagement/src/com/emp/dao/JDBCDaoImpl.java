package com.emp.dao;

import java.sql.*;

import java.util.Scanner;

import com.emp.beans.Employee;

public class JDBCDaoImpl implements Dao {

Employee emp = new Employee();
public JDBCDaoImpl() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
Scanner sc = new Scanner(System.in);
String url = "jdbc:mysql://localhost:3306/user_db"+"?user=root&password=root";

@Override
public boolean createEmployee(Employee emp) {
	String query = "INSERT INTO USERinfo "+" values(?,?,?,?) ";
	try(Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(query)){
		
		 pstmt.setInt(1,(emp.getId()));
		 pstmt.setString(2, emp.getName());
		 pstmt.setString(3, emp.getEmail());
		 pstmt.setString(4, emp.getPassword());
		int i = pstmt.executeUpdate();
		if(i>0)
		{
			
			return true;
		}
		else
		{
			return false;
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return false;
}

@Override
public Employee getEmployee(int id){
	String query = "SELECT * FROM USERinfo";
					try(Connection conn = DriverManager.getConnection(url);
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(query)){
		 
		 
		while(rs.next())
		{
			int userid = rs.getInt("emp_id");
			String username = rs.getString("username");
			String email = rs.getString("email");
			emp.setId(userid);
			emp.setName(username);

			emp.setEmail(email);
			System.out.println(emp.toString());


		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return emp;
}

@Override
public boolean updateEmployee(Employee emp) {

	String query = "UPDATE USERinfo"
			+" SET username = ?,email = ?"
			+" WHERE emp_id = ? AND password = ?";
	try(Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(query)){ 
		int userid=emp.getId();
		String username = emp.getName();
		String email = emp.getEmail();
		String passwd = emp.getPassword();
		
	   pstmt.setInt(3, userid);
		pstmt.setString(1, username);
		pstmt.setString(2, email);
		pstmt.setString(4, passwd);
		
		int i = pstmt.executeUpdate();
		if(i>=1)
		{
		
		return true;
		}
		else
		{
			return false;
		}


	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
	
}

@Override
public boolean deleteEmployee(Employee emp) {
	String query = "DELETE FROM USERinfo "	
			+"WHERE emp_id = ? AND password= ?";
	
	try(Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(query)){ 
		int userid=emp.getId();
		String passwd = emp.getPassword();
		pstmt.setInt(1, userid);
		pstmt.setString(2, passwd);
		int i = pstmt.executeUpdate();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
}catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return false;

}

}