/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationcontrollerpattern;

import java.util.*;

/**
 *
 * @author melissamoore
 */
public class ApplicationsControllerPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // scanner so will recognize users keyboard input
        Scanner input = new Scanner(System.in);
        ApplicationController calculate = new ApplicationController();
        Integer input1;
        Integer input2;
        Boolean error;
        String choice;

        do {
            try {
                error = false;
                System.out.println("Enter a number:");
                input1 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException nfe) {
                error = false;
                System.out.println("Not a valid number");
                System.out.println("Enter a number:");
                input1 = Integer.parseInt(input.nextLine());
            }
            if (input1 == 0) {
                error = true;
                System.out.println("Value must be greater than zero");
            }

        } while (error);

        do {
            try {
                error = false;
                System.out.println("Enter another number");
                input2 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException nfe) {
                error = false;
                System.out.println("Not a valid number");
                System.out.println("Enter another number");
                input2 = Integer.parseInt(input.nextLine());
            }
            if (input2 == 0) {
                error = true;
                System.out.println("Value must be greater than zero");
            }
        } while (error);

        do {
            try {
                error = false;
                System.out.print("Enter the letter to find\n" + "A = Area of Rectangle\n"
                        + "P = Perimeter of Rectangle\n" + "T = Area of Triangle\n");
                choice = input.nextLine().toUpperCase();
                if (choice.equals("A") || choice.equals("T") || choice.equals("P")) {
                    //ApplicationController.handleIt(choice, input1, input2);
                    calculate.handleIt(choice, input1, input2);
                } else {
                    error = true;
                    System.out.println("Not a valid entry");
                }

            } catch (NullPointerException npe) {
                error = true;
                System.out.println("Not a valid choice");

            }
        } while (error);

    }

}
