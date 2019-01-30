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
public class AreaOfRectangle implements Handler {
    @Override
    public void execute(Integer input1, Integer input2){
        Integer area = input1 * input2;
        System.out.println("If length is " + input1 + " and" + " width is " 
                            + input2 + " Then the area of the rectangle = " + area);
    }
    
}
