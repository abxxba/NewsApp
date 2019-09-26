package com.example.newsapp.Fragments.Home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;


public class homeFragment extends Fragment {

   SmartTabLayout smartTabLayout;

    public homeFragment() {
        // Required empty public constructor
    }


    public static homeFragment newInstance(String title) {
        homeFragment fragment = new homeFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        return view;
    }

}
