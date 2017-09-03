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
public class HelloThread extends Thread {
    public HelloThread(String name){
        super(name);
    }
    
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                System.out.println(e);
            }
            
            System.out.println(Thread.currentThread().getName() + " i = " + i);
            
        }
        
    }
    
}
