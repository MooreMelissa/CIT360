/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.*;

/**
 *
 * @author melissamoore
 */
public class Hibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentDAO stu = StudentDAO.getInstance();

        List<Student> students = stu.getStudents();
        for (Student i : students) {
            System.out.println(i);
            System.out.println("It works");
        }

        System.out.println(stu.getStudents(2));

        Integer stuId1 = stu.addStudent("Fiona");
        Integer stuId2 = stu.addStudent("Marc");
        Integer stuId3 = stu.addStudent("Anthony");

        System.out.println("New Student Fiona " + " Student ID " + stuId1);
        System.out.println("New Student Marc " + "Student ID " + stuId2);
        System.out.println("New Student Anthony " + " Student ID " + stuId3);

        //System.out.println(studentId1);
        List<Student> stunew = stu.getStudents();
        for (Student i : stunew) {
            System.out.println(i);

        }

    }

}
