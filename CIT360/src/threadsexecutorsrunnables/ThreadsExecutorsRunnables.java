/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsexecutorsrunnables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author melissamoore
 */
public class ThreadsExecutorsRunnables {
    /**
     * @param args the command line arguments
     */
    
    // Max number of threads in thread pool 
    static final int MAX_T = 3;
    
    public static void main(String[] args) {
        
       // MyRunnable myRun = new MyRunnable();
        //Thread thdRun = new Thread(myRun);
        //thdRun.start();
        //myRun.run();
        
        //creates 6 tasks
        Runnable run1 = new MyRunnable("task 1");
        Runnable run2 = new MyRunnable("task 2");
        Runnable run3 = new MyRunnable("task 3");
        Runnable run4 = new MyRunnable("task 4");
        Runnable run5 = new MyRunnable("task 5");
        Runnable run6 = new MyRunnable("task 6");
        
        // creates a thread pool with MAX_T number of threads as the fixed pool size
        
        ExecutorService fixedpool = Executors.newFixedThreadPool(MAX_T);
        
        // passes the Task objects to the pool to execute
        fixedpool.execute(run1);
        fixedpool.execute(run2);
        fixedpool.execute(run3);
        fixedpool.execute(run4);
        fixedpool.execute(run5);
        fixedpool.execute(run6);
        
        //pool shutdown
        fixedpool.shutdown();
        
        
        
           

    }
}
