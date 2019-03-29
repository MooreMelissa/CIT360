/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StudentInfo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author melissamoore
 */
@WebServlet(name="StudentInfoServlet", urlPatterns=("/StudentInfoServlet"))
public class StudentInfoServlet extends HttpServlet {
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // add request header
       // add request header
       
        response.setContentType("text/html;charset=UTF-8");
        
       // try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
       //     out.println("<!DOCTYPE html>");
       //     out.println("<html>");
       //     out.println("<head>");
       //     out.println("<title>Servlet StudentInfoServlet</title>");            
       //     out.println("</head>");
       //     out.println("<body>");
       //     out.println("<h1>Servlet StudentInfoServlet at " + request.getContextPath() + "</h1>");
       //     out.println("</body>");
       //     out.println("</html>");
       
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
           requestDispatcher = request.getRequestDispatcher("/WEB-INF/Failure.jsp");
           requestDispatcher.forward(request, response);
        }
            
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
       /**
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
        */
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
