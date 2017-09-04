/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author zhengdongwang
 */
public class KeyValuePairs<K, V> implements Pair<K, V> {
    private final K key;
    private final V value;
    
    public KeyValuePairs(K key, V value){
        this.key = key;
        this.value = value;
        
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }
    
    
}
