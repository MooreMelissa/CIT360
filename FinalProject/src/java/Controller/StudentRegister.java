/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StudentInfo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author melissamoore
 */
public class StudentRegister implements Handler {
    
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
        response.setContentType("text/html");
        boolean flag = false;
        RequestDispatcher requestDispatcher = null;
        try{
            StudentInfo student= new StudentInfo();
          
            student.setFirstname(request.getParameter("firstname"));
            student.setLastname(request.getParameter("lastname"));
            student.setAge(Integer.parseInt(request.getParameter("age")));
            student.setPhone(request.getParameter("phone"));
            student.setPianolevel(request.getParameter("pianolevel"));
            
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            
            Session session = sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.save(student);
            transaction.commit();
            flag=true;
            
            
            
        } 
        catch(NumberFormatException | HibernateException e){
           PrintWriter out = response.getWriter();
            out.println(e); 
        }
        
        if (flag) {
           requestDispatcher = request.getRequestDispatcher("/WEB-INF/Success.jsp");
           requestDispatcher.forward(request, response);
        } else {
           requestDispatcher = request.getRequestDispatcher("/WEB_INF/Failure.jsp");
           requestDispatcher.forward(request, response);
        }
    }    
    
}
