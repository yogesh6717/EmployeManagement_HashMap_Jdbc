package com.emp.services;

import com.emp.beans.Employee;
import com.emp.dao.Dao;
import com.emp.repository.Database;

public class HashServiceImpli implements Service {
	Database db = new Database();
	@Override
	public boolean createEmployee(Employee emp) {
	
		boolean res = db.addEmp(emp);
		return res;
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return db.getEmployee(id);
		
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		boolean res1 = db.updateEmp(emp);

		return res1;
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
	return db.deleteEmployee(emp);
		
	}

}
