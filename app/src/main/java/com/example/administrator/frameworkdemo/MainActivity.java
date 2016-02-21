package com.example.administrator.frameworkdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.administrator.frameworkdemo.adapter.FragmentAdapter;
import com.example.administrator.frameworkdemo.fragments.Fragment1;
import com.example.administrator.frameworkdemo.fragments.Fragment2;
import com.example.administrator.frameworkdemo.fragments.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{

    private DrawerLayout mDrawerlayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FloatingActionButton floatingActionButton;
    FragmentAdapter  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        toolbar  = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        adapter = new FragmentAdapter(getSupportFragmentManager(),addFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case android.R.id.home:
                mDrawerlayout.openDrawer(GravityCompat.START);
                return true;

        }



        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        item.setChecked(true);
        mDrawerlayout.closeDrawers();
        Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                Snackbar.make(findViewById(R.id.coordinatorlayout),"i am snackbar",Snackbar.LENGTH_LONG).setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Snackbar Action", Toast.LENGTH_LONG).show();

                    }
                }).show();
                break;
        }
    }


    private List<Fragment> addFragment(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(Fragment1.newInstance());
        fragments.add(Fragment2.newInstance());
        fragments.add(Fragment3.newInstance());
        return fragments;
    }
}
