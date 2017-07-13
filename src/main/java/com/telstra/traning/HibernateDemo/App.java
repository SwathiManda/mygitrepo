package com.telstra.traning.HibernateDemo;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Employee emp=new Employee();
        emp.setEmpname("Swathi");
        Employee emp2=new Employee();
        emp2.setEmpname("Alekhya");
        Employee emp3=new Employee();
        emp3.setEmpname("anu");        
        Student s1=new Student();
        s1.setSname("siva");
        Session session=HibernateSessionUtil.createHibernateSession();
        session.beginTransaction();
        session.save(emp);
        session.save(emp2);
        session.save(emp3);
        session.save(s1);
        session.getTransaction().commit();
        @SuppressWarnings("unchecked")
		Query<Employee> q=session.createNamedQuery("findEmployeeByName");
        q.setParameter("name", "anu");
        List<Employee> employeeList=(List<Employee>)q.list();
        @SuppressWarnings("unchecked")
		Query<Student> query=session.createNamedQuery("findStudentByName");
        query.setParameter("sname","siva");
        List<Student> studentList=(List<Student>)query.list();
        session.close();
        for (Student s:studentList) {
        	System.out.println(s.getSname()+s.getSid());
        }
        for (Employee e:employeeList) {
        	System.out.println(e.getEmpname()+e.getEmpid());
        }
        
        
        
    }
}
