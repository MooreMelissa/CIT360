/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controller.StudentInfoServlet;
import Controller.StudentRegister;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author melissamoore
 */
public class Testing extends Mockito {
    
    public Testing() {
    }

    @Test
    public void AllTests() throws IOException, ServletException{
       
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);  
        RequestDispatcher rq = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/WEB-INF/Success.jsp")).thenReturn(rq);
     

        when(request.getParameter("firstname")).thenReturn("Sam");
        when(request.getParameter("lastname")).thenReturn("Secret");
        when(request.getParameter("age")).thenReturn("12");
        when(request.getParameter("phone")).thenReturn("3335551234");
        when(request.getParameter("pianolevel")).thenReturn("2");
     

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new StudentRegister().execute(request, response);

        verify(request, atLeast(1)).getParameter("firstname"); // only if you want to verify username was called...
        verify(request, times(1)).getRequestDispatcher("/WEB-INF/Success.jsp");
        //writer.flush(); // it may not have been flushed yet...
        //assertTrue(stringWriter.toString().contains("My expected string"));
        
        
    }
    
    
} 
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

