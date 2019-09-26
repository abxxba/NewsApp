package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.newsapp.Dialogs.signUpDialog;
import com.example.newsapp.Fragments.Home.homeFragment;
import com.example.newsapp.utils.viewPagerAdabter;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    NavigationView navigationView;

    Toolbar toolbar;
    SmartTabLayout viewpagertab;
    ViewPager viewPager;

    int REC_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //SET UP NAV DRAWER
        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, R.string.drawer_layout_open, R.string.drawer_layout_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //SET UP VIEW PAGER WITH TABS
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewpagertab = (SmartTabLayout) findViewById(R.id.viewpagertab);

        List<Fragment> fragmwntsList = new ArrayList<>();
        fragmwntsList.add(homeFragment.newInstance(getResources().getString(R.string.home)));
        fragmwntsList.add(homeFragment.newInstance(getResources().getString(R.string.home)));

        viewPagerAdabter adabter = new viewPagerAdabter(getSupportFragmentManager(),fragmwntsList);

        viewPager.setAdapter(adabter);
        viewpagertab.setViewPager(viewPager);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account == null) {
            showSignInUpDialog();
        } else {
            //showSignInUpDialog();
        }
    }

    private void showSignInUpDialog() {
        DialogFragment newFragment = signUpDialog.newInstance(MainActivity.this);
        newFragment.show(getSupportFragmentManager(), "dialog");
    }


}
