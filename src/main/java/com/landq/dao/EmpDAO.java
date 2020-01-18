package com.landq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

import com.landq.bean.Employee;

public class EmpDAO {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public Session getSession(boolean beginTransaction) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		if (beginTransaction) {
			session.beginTransaction();
		}
		return session;

	}

	public List<Employee> getEmployees() {
		Session session = this.getSession(false);
		try {
			Criteria criteria = session.createCriteria(Employee.class);
			List<Employee> Employee_list = criteria.list();
			System.out.println("Inside getEmployees");
			return Employee_list;
		} catch (Exception exception) {
			System.out.println("Error occured while fetching Employee data : " + exception);
			return null;
		}finally{
			this.close(session);
		}
		/*
		 * return template.query("Select * from Employee",new
		 * RowMapper<Employee>(){ public Employee mapRow(ResultSet rs, int row)
		 * throws SQLException { Employee e=new Employee();
		 * e.setId(rs.getInt(1)); e.setName(rs.getString(2));
		 * e.setSalary(rs.getFloat(3)); e.setDesignation(rs.getString(4));
		 * System.out.println(e.getId()+"  "+e.getName()+"  "+e.getSalary()
		 * +"   "+e.getDesignation()); return e; } });
		 */
	}

	public Employee getEmployeeByID(int id) {
		Session session = this.getSession(false);
		
		try {

			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("id", id));
			List<Employee> employee = criteria.list();
			System.out.println("Inside getEmployeeById");
			return employee.get(0);
		} catch (Exception exception) {
			System.out.println("Error occured while fetching specific employee : " + exception);
			return null;
		}finally{
			this.close(session);
		}
		/*
		 * String sql="Select * from employee where id=?"; return
		 * template.queryForObject(sql, new Object[]{id},new
		 * BeanPropertyRowMapper<Employee>(Employee.class));
		 */
	}

	public int deleteEmp(int id) {
		Session session =this.getSession(true);
		try {
			Criteria criteria = getSession(false).createCriteria(Employee.class);
			criteria.add(Restrictions.eq("id", id));
			System.out.println(criteria.list().get(0));
			session.delete(criteria.list().get(0));
			session.getTransaction().commit();
			System.out.println("Inside deleteEmp");
			return 1;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Error occured while deleting : " + e);
			return 0;
		}
		finally{
			this.close(session);
		}

		/*
		 * Configuration con=new
		 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(
		 * Employee.class); SessionFactory sf=con.buildSessionFactory(); Session
		 * s=sf.openSession(); s.beginTransaction(); Employee emp=new
		 * Employee(); emp.setId(id); s.delete(emp);
		 * s.getTransaction().commit(); return 1;
		 */

		/*
		 * String sql="delete from employee where id="+id+""; return
		 * template.update(sql);
		 */
	}

	public int addEmployee(Employee employee) {
		System.out.println("Inside "+employee.getId()+" "+employee.getName()+" "+employee.getSalary()+" "+employee.getDesignation());
		Session session=getSession(true);
		try {
			
			session.save(employee);
			System.out.println("Saved !");
			session.getTransaction().commit();
			System.out.println("Inside addEmployee (Status): " + employee.getId());
			return 1;
		} catch (Exception exception) {
			session.getTransaction().rollback();
			System.out.println("Error occured while inserting data " + exception);
			return 0;
		}finally{
			this.close(session);
		}

		/*
		 * System.out.println("Enters!"); Configuration con=new
		 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(
		 * Employee.class);
		 * System.out.println("Configuration created successfully !");
		 * //ServiceRegistry reg=new
		 * ServiceRegistryBuilder().applySettings(con.getProperties().
		 * buildServiceRegistey(); //Session session
		 * =con.buildSessionFactory(reg); SessionFactory
		 * sf=con.buildSessionFactory();
		 * System.out.println("Session factory created!"); Session session
		 * =sf.openSession(); System.out.println("Session created !");
		 * Transaction tx=session.beginTransaction();
		 * System.out.println("Transaction started"); session.save(e);
		 * System.out.println("Operation executed"); tx.commit();
		 * System.out.println("Transaction commited--");
		 */
		// return 1;

		// String sql="insert into Employee(name,salary,designation)
		// values('"+e.getName()+"',"+e.getSalary()+",'"+e.getDesignation()+"')";
		// return template.update(sql);

	}

	public int updateEmployee(Employee employee) {
		Session session=getSession(true);
		try {
			session.update(employee);
			session.getTransaction().commit();
			System.out.println("Inside updatEmployee");
			return 1;
		} catch (Exception exception) {
			session.getTransaction().rollback();
			System.out.println("Error occured while updating : " + exception);
			return 0;
		}finally{
			this.close(session);
		}

		/*
		 * Configuration con1=new
		 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(
		 * Employee.class); SessionFactory sf1=con1.buildSessionFactory();
		 * Session session=sf1.openSession(); session.beginTransaction();
		 * session.update(p); session.getTransaction().commit(); return 1;
		 */

		/*
		 * String
		 * sql="update Employee set name='"+p.getName()+"', salary="+p.getSalary
		 * ()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";
		 * return template.update(sql);
		 */
	}

	private void close(Session session) {
		if (session != null) {
			session.close();
		}
	}
}