/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author melissamoore
 */
public class EditStudentList implements Handler {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        boolean flag = false;
        RequestDispatcher requestDispatcher = null;
        try {

            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Transaction tx = null;

            Session session = sessionFactory.openSession();

            tx = session.getTransaction();
            tx.begin();

            String hql = "UPDATE StudentInfo set phone = :phone " + "WHERE ID = :id";
            Query query = session.createQuery(hql);

            query.setParameter("phone", request.getParameter("phone"));
            query.setParameter("id", request.getParameter("id"));
            int result = query.executeUpdate();

            tx.commit();
            session.close();
            flag = true;

        } catch (HibernateException ex) {
            System.err.println("Failed to create sessionFactory object" + ex);
            throw new ExceptionInInitializerError(ex);

        }

        if (flag) {
            PianoStuTesting.hibernateMessage = true;
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/Success.jsp");
            requestDispatcher.forward(request, response);
        } else {
            PianoStuTesting.hibernateMessage = false;
            requestDispatcher = request.getRequestDispatcher("/WEB_INF/Failure.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}
