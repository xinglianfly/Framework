package com.example.administrator.frameworkdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by xiner on 16/2/21.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragmentList;

   public FragmentAdapter(FragmentManager fm,List<Fragment>fragments){
       super(fm);
       this.fragmentList = fragments;
   }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab"+fragmentList.get(position).getClass().getSimpleName();
    }
}
