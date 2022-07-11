package com.pro.wings.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.wings.entity.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addEmployee(Employee entity) {

		try {
			Session session = sessionfactory.openSession();
			Transaction txc = session.beginTransaction();

			session.save(entity);

			txc.commit();
			session.close();
			return true;
		} 
		catch (Exception e) {
			System.out.println("Not save Employee object...");
			e.printStackTrace();
			return false;

		}

	}
}
