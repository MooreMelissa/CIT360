/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StudentInfo;
import java.io.FileWriter;
import java.io.IOException;
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
import org.json.simple.JSONObject;

/**
 *
 * @author melissamoore
 */
public class StudentList implements Handler {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        boolean flag = false;
        RequestDispatcher requestDispatcher = null;
        try {
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            Session session = sessionFactory.openSession();

            String hql = "SELECT s FROM StudentInfo s";

            Query<StudentInfo> query = session.createQuery(hql);

            List list = query.list();

            session.close();

            List<StudentInfo> listResults = list;

            String store = "";

            for (int i = 0; i < listResults.size(); i++) {
                StudentInfo stulis = new StudentInfo();
                stulis.setId(listResults.get(i).getId());
                stulis.setFirstname(listResults.get(i).getFirstname());
                stulis.setLastname(listResults.get(i).getLastname());
                stulis.setAge(listResults.get(i).getAge());
                stulis.setPhone(listResults.get(i).getPhone());
                stulis.setPianolevel(listResults.get(i).getPianolevel());

                JSONObject stringify = new JSONObject();

                stringify.put("id", stulis.getId());
                stringify.put("firstName", stulis.getFirstname());
                stringify.put("lastName", stulis.getLastname());
                stringify.put("age", stulis.getAge());
                stringify.put("phone", stulis.getPhone());
                stringify.put("pianoLevel", stulis.getPianolevel());

                store += stringify.toJSONString();

            }

            FileWriter writer = new FileWriter("/Users/melissamoore/NetBeansProjects/CIT360/FinalProject/textfiles/StudentList.txt");
            try {
                writer.write(store);

            } catch (IOException io) {
                io.printStackTrace();

            } finally {
                writer.flush();
                writer.close();
                flag = true;
            }

        } catch (IOException | HibernateException ex) {
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
