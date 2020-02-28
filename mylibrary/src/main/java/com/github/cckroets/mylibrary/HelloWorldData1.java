package com.github.cckroets.mylibrary;

// AS 3.6 gives: 'Cannot resolve symbol'
import com.github.cckroets.mylibrary.databinding.HelloWorld1Binding;

public class HelloWorldData1 {

    static HelloWorld1Binding binding;

    public static void hello() {
        System.out.println(binding);
    }
}
