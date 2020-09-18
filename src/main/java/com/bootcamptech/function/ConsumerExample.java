package com.bootcamptech.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    /*
         This method now has side-effect
     */
    public static Consumer<List<String>> normalizeNames = list -> {
        for(int i = 0 ; i < list.size()  ; i++){

            list.set(i, list.get(i).substring(0,1).toUpperCase()
                    + list.get(i).substring(1,list.get(i).length()).toLowerCase());
        }
    };

    public static Consumer<List<String>> print = s-> System.out.println(s);


    public static void main(String[] args) {

        List<String> names = Arrays.asList("ashok", "Kishore", "NAKUL", "moHit");

        normalizeNames.andThen(print).accept(names);
    }
}
