package com.example.newsapp.utils;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class viewPagerAdabter extends FragmentPagerAdapter {

    private List<Fragment> FragmentList = new ArrayList<>();

    public viewPagerAdabter(FragmentManager fragmentManager,List FragmentList) {
        super(fragmentManager);
        this.FragmentList = FragmentList;
        Log.d("fragmenttttttttt", "getItem: "+this.FragmentList.size());
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("fragmenttttttttt", "getItem: "+position);
        return FragmentList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentList.size();
    }

    public void addFrag(Fragment fragment, String title) {
        FragmentList.add(fragment);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentList.get(position).getArguments().getString("title");
    }

}
