package com.example;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // CREATE
            Employee emp = new Employee();
            emp.setId(1);
            emp.setName("John Doe");
            emp.setDepartment("IT");
            emp.setSalary(50000);
            session.save(emp);

            // READ
            String hql = "FROM Employee";
            List<Employee> employees = session.createQuery(hql).list();
            for (Employee e : employees) {
                System.out.println(e.getId() + " " + e.getName());
            }

            // UPDATE
            hql = "UPDATE Employee set salary = :salary WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("salary", 60000.0);
            query.setParameter("id", 1);
            query.executeUpdate();

            // DELETE
            hql = "DELETE FROM Employee WHERE id = :id";
            query = session.createQuery(hql);
            query.setParameter("id", 1);
            query.executeUpdate();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
