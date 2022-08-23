package com.ms.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ms.Model.Employee;
import com.ms.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public void addEmployee(Employee emp) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.persist(emp);
		
		session.getTransaction().commit();
		
		session.close();
		
	}

	public long totalEmployees() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("SELECT COUNT(*) from Employee", Long.class);
		
		Long result = (Long) query.getSingleResult();
		
		session.close();
		return result;
	}

	public List<Employee> getEmployee() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
	    Query query = session.createQuery("Select * from Employee E ORDER BY E.empName");
	    List<Employee> empList = query.getResultList();
	    
		return empList;
	}

	public void updatePassword(int empId, String newPassword) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		Employee employee = session.load(Employee.class, empId);
		employee.setPassword(newPassword);
		
		session.merge(employee);
		
		session.getTransaction().commit();
		
		session.close();
		
		
	}

	public void deleteEmployeeRecord(int empId) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		Employee employee = session.load(Employee.class, empId);
		
		session.delete(employee);
		
		session.getTransaction().commit();
		
		session.close();
	}

	public void getEmployeeAndAssetDetails(int empId) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		Query query = session.createQuery("Select E.empName, A.assetType from Employee E INNER JOIN E.assetID A where "
				+ "E.empId = :empId");
		
		query.setParameter("empId", empId);
		
		List<Object[]> list = query.list();
		
		for(Object[] arr : list){
			System.out.println(Arrays.toString(arr));
		}
		
	}
	
	

}
