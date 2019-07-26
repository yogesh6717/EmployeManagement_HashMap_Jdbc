package com.emp.dao;

import com.emp.beans.Employee;

public interface Dao {

	public boolean createEmployee(Employee emp);
	
	public Employee getEmployee(int id);
	
	public boolean updateEmployee(Employee emp);
	
	public boolean deleteEmployee(Employee emp);
	

}
