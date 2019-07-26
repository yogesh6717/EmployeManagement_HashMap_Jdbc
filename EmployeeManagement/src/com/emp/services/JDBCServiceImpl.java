package com.emp.services;

import com.emp.beans.Employee;
import com.emp.dao.Dao;
import com.emp.dao.JDBCDaoImpl;

public class JDBCServiceImpl implements Service {
	
		
		Dao dao =  new JDBCDaoImpl();


		@Override
		public boolean createEmployee(Employee emp) {
			
			return dao.createEmployee(emp);
		}


		@Override
		public Employee getEmployee(int id) {
			Dao dao1 =  new JDBCDaoImpl();

			return dao1.getEmployee(id);
		}


		@Override
		public boolean updateEmployee(Employee emp) {
			Dao dao2 =  new JDBCDaoImpl();

			return dao2.updateEmployee(emp);
		}


		@Override
		public boolean deleteEmployee(Employee emp) {
			Dao dao3 =  new JDBCDaoImpl();

			
			return dao3.deleteEmployee(emp);
		}


		

	}

