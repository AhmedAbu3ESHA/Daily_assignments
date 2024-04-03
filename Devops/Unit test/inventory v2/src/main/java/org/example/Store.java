package org.example;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Store {

    HashMap<String, Integer> product = new HashMap<String, Integer>();

    public Store() {
        product.put("chair",5);
        product.put("table",7);
    }
    int p =0;
    public int add(String type,int num){
        for (Map.Entry<String, Integer> Key:product.entrySet()) {
            if (type.equals(Key.getKey())&&num<=100){
                Key.setValue(Key.getValue()+num);
                p=1;
                break;
            }
            else p= 0;
        }
        return p;
    }

    public int remove(String type,int num){
        for (Map.Entry<String, Integer> Key:product.entrySet()) {
            if (type.equals(Key.getKey())&&Key.getValue()>= num && num>0){
                Key.setValue(Key.getValue()-num);
                p=1;
                break;
            }
            else p= 0;
        }
        return p;
    }
}
