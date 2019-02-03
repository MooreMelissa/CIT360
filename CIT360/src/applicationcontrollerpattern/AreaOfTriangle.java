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
public class AreaOfTriangle implements Handler {

    @Override
    public void execute(Integer input1, Integer input2) {
        Integer triangle = (input1 * input2) / 2;
        System.out.println("If base is " + input1 + " and "
                + "height is " + input2 + " Then the area of the triangle = " + triangle);
    }

}
