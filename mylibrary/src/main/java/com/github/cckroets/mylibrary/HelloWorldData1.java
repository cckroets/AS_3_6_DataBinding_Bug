package com.github.cckroets.mylibrary;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.github.cckroets.mylibrary.databinding.HelloWorld1Binding;
import com.github.cckroets.mylibrary2.databinding.HelloWorld2Binding;

public class HelloWorldData1 {

    public static void hello(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup container) {
        HelloWorld1Binding binding = HelloWorld1Binding.inflate(layoutInflater, container, false);

        // AS 3.6 gives: 'Incompatible types.'
        // Required: com.github.cckroets.mylibrary2.databinding.HelloWorld2Binding
        // Found:    com.github.cckroets.mylibrary.databinding.HelloWorld2Binding
        HelloWorld2Binding nestedBinding = binding.hello2;
    }
}
