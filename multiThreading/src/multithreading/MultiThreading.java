/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhengdongwang
 */
public class MultiThreading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
            
//      newRunnableExamples();
//           waitExample();
//      SynchronizedBlockExample();
//        waitExample(); 
//         joinExample();
executorExample();

    }
    
    public static void newRunnableExamples(){
          (new Thread(new HelloRunnable())).start();
        Runnable r1 = (new HelloRunnable());
        Thread t1 = new Thread(r1);
        t1.start();
        
        Runnable r2 = () -> System.out.println("Hello from " + Thread.currentThread().getName());
        
        Thread thread = new Thread(r2, "testing thread 2");
        System.out.println("Thread status for " + thread.getName() + " is " + thread.getState());
        
        thread.start();
        System.out.println("Thread status for " + thread.getName() + " is " + thread.getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MultiThreading.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println("Thread status for " + thread.getName() + " is " + thread.getState());
         
         
    }
    
    public static void joinExample(){
        
        HelloThread t1 = new HelloThread("t1");
        HelloThread t2 = new HelloThread("t2");
        HelloThread t3 = new HelloThread("t3");
        t1.start();
        t2.start();
        
        //code below the join is not execuetd until t2 finishes
        //join is a special waits that automatically got notified when t2 finishes
        try {
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MultiThreading.class.getName()).log(Level.SEVERE, null, ex);
        }
        t3.start();
        
        
    }
    
    public static void SynchronizedBlockExample(){
        
        CountdownBlast cb = new CountdownBlast();
        
        Runnable r = () -> {
            synchronized(cb){
                cb.countdown();
                
            }
        };
               
        
        Thread t1 = new Thread(r,"t1 ");
        Thread t2 = new Thread(r,"t2 ");

        t1.start();
        t2.start();
    }
    
    
    public static  void waitExample() throws InterruptedException  {
        
        WaitAndNotifyExample b = new WaitAndNotifyExample();
//                ThreadB b = new ThreadB();

        b.start();
        synchronized(b){
            System.out.println("waiting for b to notify");
            b.wait();
        }
//        
//        
        System.out.println("total is: " + b.total);
//        
              
        
    }
    
    public static void executorExample(){
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        for(int i =0; i < 10; i ++){
            
            Runnable worker = () -> {
                System.out.println("thread "+Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MultiThreading.class.getName()).log(Level.SEVERE, null, ex);
                }
            };
            
            executor.execute(worker);
        }
        
        System.out.println("execution finished");
        executor.shutdown();
        System.out.println("executor scheduled for shutdown");
        
        while(!executor.isShutdown()){
            System.out.println("executor not shut down yet");
        }

                System.out.println("executor is shutdown");

        
    }

    
       public static void countDownLatch(String[] args) throws InterruptedException {
           //2 start.countdown must be called when all Thread holding reference to start.wait will proceed
        CountDownLatch start = new CountDownLatch(2);
        //4 end.countdown must be called before mainthread proceed
        CountDownLatch end = new CountDownLatch(4);
        // create and start threads
        for (int i = 0; i < 5; ++i) 
            new Thread(new Worker(start,end)).start();

        try{
         System.out.println("main thread doing something");
         Thread.sleep(1000); // sleep for 1 second
         
         start.countDown(); // let all threads proceed
         start.countDown(); // let all threads proceed

         System.out.println("main thread doing something else");
         end.await(); // wait for all threads to finish
         
      }
      catch (InterruptedException ie)
      {
         System.err.println(ie);
      }
    }
    
     

    

}
