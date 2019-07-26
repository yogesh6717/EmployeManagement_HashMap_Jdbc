package com.emp.dao;

import com.emp.beans.Employee;
import com.emp.repository.Database;

public class HashDaoImpli implements Dao {

	Database db = new Database();
	@Override
	public boolean createEmployee(Employee emp) {

		boolean res = db.addEmp(emp);

		return res;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee emp = db.getEmployee(id);
		return emp;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
	boolean res1 = db.updateEmp(emp);
		return res1;
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
		boolean res3 = db.deleteEmployee(emp);

		return res3;
		
	}
	

}
