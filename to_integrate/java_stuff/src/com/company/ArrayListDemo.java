package com.company;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class ArrayListDemo {
    public static void main(String[] args) {
        Map<String, String> phonebook=new TreeMap<String, String>();
        phonebook.put("Mark", "54534543");
        phonebook.put("Doron", "3435435");
        for(Map.Entry<String,String> e:phonebook.entrySet()) {
            System.out.println(e.getKey()+" "+e.getValue());
        }

    }
}
