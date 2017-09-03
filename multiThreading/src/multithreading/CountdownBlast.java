package multithreading;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhengdongwang
 */
public class CountdownBlast {
    public void countdown(){
        for(int i = 10; i > 0; i--){
                    System.out.println(Thread.currentThread().getName()+i);

        }
        
        System.out.println("Blast");
    }
   
    
}
