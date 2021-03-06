/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author melissamoore
 */
public class StudentDAO {

    SessionFactory factory = null;
    Session session = null;

    private static StudentDAO singleInstance = null;

    private StudentDAO() {
        factory = HibernateUtils.getSessionFactory();
    }

    public static StudentDAO getInstance() {
        if (singleInstance == null) {
            singleInstance = new StudentDAO();
        }
        return singleInstance;
    }

    public List<Student> getStudents() {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from hibernate.Student";
            List<Student> students = (List<Student>) session.createQuery(sql).getResultList();

            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;

        } finally {
            session.close();

        }

    }

    public Student getStudents(int id) {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql;
            sql = "from hibernate.Student where ID=" + Integer.toString(id);
            Student students;
            students = (Student) session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();

        }
    }

    public Integer addStudent(String name) {
        Session addSession = factory.openSession();
        Transaction tx = null;
        Integer studentsID = null;

        try {
            tx = addSession.beginTransaction();
            Student students = new Student(name);
            studentsID = (Integer) addSession.save(students);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentsID;
    }

}
