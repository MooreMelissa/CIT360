/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StudentInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author melissamoore
 */
public class DisplayStudentList implements Handler {
   
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        try {
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            
            Session session = sessionFactory.openSession();
           
            String hql = "SELECT s FROM StudentInfo s";
           
            Query<StudentInfo> query = session.createQuery(hql);
            
             List list = query.list();
            
            session.close();
            
            List<StudentInfo> listResults = list;
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            
            String table = "<table>";
            
            for (int i = 0; i < listResults.size(); i++) {
                table += "<tr>";
                table += "<td>";
                table += Integer.toString(listResults.get(i).getId());
                table += "</td>";
                table += "<td>";
                table += listResults.get(i).getFirstname();
                table += "</td>";
                table += "<td>";
                table += listResults.get(i).getLastname();
                table += "</td>";
                table += "<td>";
                table += Integer.toString(listResults.get(i).getAge());
                table += "</td>";
                table += "<td>";
                table += listResults.get(i).getPhone();
                table += "</td>";
                table += "<td>";
                table += listResults.get(i).getPianolevel();
                table += "</td>";
                table += "</tr>";            
                
            }
               table += "</table>";
               out.write(table);
               
               
               out.write("<br><br><br><a href=\"index.html\">Return Home Page</a>");
       
        } catch (HibernateException ex) { 
                System.err.println("Failed to create sessionFactory object" + ex);
                throw new ExceptionInInitializerError(ex);
        } 
           
            
    }
        
}    
    


   
