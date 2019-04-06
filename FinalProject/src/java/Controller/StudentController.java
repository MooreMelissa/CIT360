/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import static java.lang.System.out;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author melissamoore
 */
public class StudentController {
    public static HashMap<String, Handler> hashMapOfChoices = new HashMap<String, Handler>();

    public  StudentController() {
        hashMapOfChoices.put("submit", new StudentRegister());
        hashMapOfChoices.put("list", new StudentList());
    }


    public static void handleIt(String choice, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        Handler math = hashMapOfChoices.get(choice);
       // out.println(choice + hashMapOfChoices.containsKey(choice));
        math.execute(request, response);
        
    }
    
    
}

    

