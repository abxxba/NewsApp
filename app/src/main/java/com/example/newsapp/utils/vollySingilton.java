package com.example.newsapp.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class vollySingilton {
    private static vollySingilton volly;
    private static RequestQueue requestQueue;
    private static Context mycontext;

    public vollySingilton(Context context) {
        mycontext = context;
    }

    public static synchronized vollySingilton getInstance(Context context) {
        volly = new vollySingilton(context);
        requestQueue = Volley.newRequestQueue(context);
        requestQueue.getCache().clear();
        return volly;
    }

    public static void addToQuee(Request request) {
       request.setShouldCache(false);
        requestQueue.add(request);
        Log.d("vollynoc", "addToQuee: => "+requestQueue.toString());
    }
}
