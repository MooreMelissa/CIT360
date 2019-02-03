/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationcontrollerpattern;

/**
 *
 * @author melissamoore
 */
public class PerimeterOfRectangle implements Handler {

    @Override
    public void execute(Integer input1, Integer input2) {
        Integer perimeter = 2 * input1 + 2 * input2;
        System.out.println("If length is " + input1 + " and "
                + "width is " + input2 + " Then the perimeter of the rectangle = " + perimeter);
    }

}
