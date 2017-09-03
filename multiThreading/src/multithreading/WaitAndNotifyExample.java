/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author zhengdongwang
 */
public class WaitAndNotifyExample extends Thread{
    
     int total;
     
    @Override
    public void run(){
        
        synchronized(this){
            
        
        for (int i=0; i<100000000; i++){
            total+=i;
                       
        }
        
        System.out.println("total from WaitAndNotify " + total);
        this.notify();
        
    }
    }
}
