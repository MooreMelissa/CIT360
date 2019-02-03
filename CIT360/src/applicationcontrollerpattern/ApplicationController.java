/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationcontrollerpattern;

import java.util.HashMap;

/**
 *
 * @author melissamoore
 */
public class ApplicationController {

    public static HashMap<String, Handler> hashMapOfChoices = new HashMap<String, Handler>();

    public void ApplicationController() {

    }

    public void handleIt(String choice, Integer input1, Integer input2) {
        hashMapOfChoices.put("A", new AreaOfRectangle());
        hashMapOfChoices.put("P", new PerimeterOfRectangle());
        hashMapOfChoices.put("T", new AreaOfTriangle());

        Handler math = hashMapOfChoices.get(choice);

        math.execute(input1, input2);
    }
}
