package com.github.cckroets.lib1;

import android.util.Log;

public class HelloWorld {

    public static void hello() {
        Log.w(HelloWorld.class.getSimpleName(), "This ID: " + com.github.cckroets.lib1.R.id.some_id);
    }
}
