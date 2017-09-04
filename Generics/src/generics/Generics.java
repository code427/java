/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import static java.lang.Math.E;
import java.util.ArrayList;

/**
 *
 * @author zhengdongwang
 */
public class Generics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Pair<Integer, String> pair = new KeyValuePairs<>(1,"hi");
        
        print(pair.getKey(),pair.getValue());
        
        Pair<String, Integer> pairReverse = new KeyValuePairs<>("hi", 1);

        print(pair.getKey(),pair.getValue());

    }
    
    
    public static <K, V> void print(K key, V value){
        System.out.println(key);
        System.out.println(value);
    }
    
    public static <T extends Comparable<T>> ArrayList<T> removeDuplicates(ArrayList<T> list){
        ArrayList<T> newList = new ArrayList<>();
        boolean found = false;
        if(list.size()==0)
            return list;
        newList.add(list.get(0));
        
        for(int i = 1; i<list.size(); i++){
            
            for(int j = 0; j<list.size(); j++){
                if(list.get(i).compareTo(newList.get(j))==0){
                    found=true;
                    break;
                }
            }
            if(found){
                newList.add(list.get(i));
            }
            found=false;
            
        }
        return newList;
    }
}
