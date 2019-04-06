/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HibernateUtils;
import Model.StudentInfo;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author melissamoore
 */
public class StudentInfoDAO {
    SessionFactory factory = null;
    Session session = null;

    private static StudentInfoDAO singleInstance = null;

    private StudentInfoDAO() {
        factory = HibernateUtils.getSessionFactory();
    }

    public static StudentInfoDAO getInstance() {
        if (singleInstance == null) {
            singleInstance = new StudentInfoDAO();
        }
        return singleInstance;
    }

    public List<StudentInfo> getStudents() {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from Model.StudentInfo";
            List<StudentInfo> students = (List<StudentInfo>) session.createQuery(sql).getResultList();

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

    public StudentInfo getStudents(int id) {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql;
            sql = "from Model.StudentInfo where ID=" + Integer.toString(id);
            StudentInfo students;
            students = (StudentInfo) session.createQuery(sql).getSingleResult();
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
            StudentInfo students = new StudentInfo(name);
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


