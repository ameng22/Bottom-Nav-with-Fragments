package com.example.demoapp1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class myAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public myAdapter(@NonNull Context context, FragmentManager fm,int totalTabs) {
        super(fm);

        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:Fragment f1 = new SettingsFragment();
                   return f1;
            case 1:Fragment f2 = new FavouriteFragment();
                return f2;
            case 2:Fragment f3 = new SettingsFragment();
                return f3;
            case 3:Fragment f4 = new LogoutFragment();
                return f4;
            case 4:Fragment f5 = new SettingsFragment();
                return f5;
            case 5:Fragment f6 = new FavouriteFragment();
                return f6;
            default:return null;

        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
