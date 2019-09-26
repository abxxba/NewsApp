package com.example.newsapp.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class httpRequests {

    public static void oathGoogle(final Context context, final vollyCallback callback) throws JSONException {
        Log.d("vollyaudition", "onResponse calledddd: ");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, httpConfig.getInstance().getServerUrl() + "/users/oath/google",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("vollyaudition", "onResponse: " + response);
                        callback.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(context, "Volly network error " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("vollyaudition", "onErrorResponse: " + error.getMessage());
                        callback.onResponse("error/" + error.getMessage());
                    }
                });
        vollySingilton.getInstance(context).addToQuee(stringRequest);
    }

}
