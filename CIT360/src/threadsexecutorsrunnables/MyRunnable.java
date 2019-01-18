/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsexecutorsrunnables;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author melissamoore
 */
public class MyRunnable implements Runnable {
   // public void run(){
       // System.out.println("It is my Runnable");
   // }
    private String name;
     
    public MyRunnable(String sname) {
        name = sname;
    }
    
    //Prints MyRunnable name and sleeps for 2s
    // The whole process is repeated 6 times
    public void run(){
        
        try{
            for(int i = 0; i<=6; i++){
                
                if (i==0){
                    
                    Date day = new Date();
                    SimpleDateFormat forDate = new SimpleDateFormat("hh:mm:ss");
                    // prints the initial start time for every task
                    System.out.println("Initial Start Time for" + " task name - " + name
                                + " = " + forDate.format(day));
                }
                else{
                    
                    Date day = new Date();
                    SimpleDateFormat forDate = new SimpleDateFormat("hh:mm:ss");
                    // prints the execution time for every task 
                    System.out.println("Execute Time for task name - " + name + " = " + forDate.format(day));
                }
                Thread.sleep(2000);
                
            }
            System.out.println(name + " complete");
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}



