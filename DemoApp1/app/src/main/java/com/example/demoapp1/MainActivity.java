package com.example.demoapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TabLayout tabLayout;

    ViewPager viewPager;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setLogo(R.drawable.baseline_mediation_24);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.drawer_nav);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int item_id = item.getItemId();

                if (item_id == R.id.frag1){
                    LoadFragment(new FavouriteFragment());
                }
                if (item_id == R.id.frag2){
                    LoadFragment(new SettingsFragment());
                }
                if (item_id == R.id.frag3){
                    LoadFragment(new LogoutFragment());
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

//        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        viewPager = (ViewPager) findViewById(R.id.view_pager);
//
//        tabLayout.addTab(tabLayout.newTab().setText("Settings"));
//        tabLayout.addTab(tabLayout.newTab().setText("Favourites"));
//        tabLayout.addTab(tabLayout.newTab().setText("Settings"));
//        tabLayout.addTab(tabLayout.newTab().setText("Logout"));
//        tabLayout.addTab(tabLayout.newTab().setText("Settings"));
//        tabLayout.addTab(tabLayout.newTab().setText("Favourites"));
//
//        setUpTabIcons();
//        tabLayout.setInlineLabel(true);
//
//        final myAdapter adapter = new myAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
//        viewPager.setAdapter(adapter);
//
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

        bottomNavigationView= (BottomNavigationView) findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int item_id = item.getItemId();

                if (item_id == R.id.menu_item1){
                    LoadFragment(new FavouriteFragment());
                }
                if (item_id == R.id.menu_item2){
                    LoadFragment(new SettingsFragment());
                }
                if (item_id == R.id.menu_item3){
                    LoadFragment(new LogoutFragment());
                }
                return true;
            }
        });

    }

//    private void setUpTabIcons() {
//        tabLayout.getTabAt(0).setIcon(R.drawable.baseline_mediation_24);
//        tabLayout.getTabAt(1).setIcon(R.drawable.baseline_favorite_24);
//        tabLayout.getTabAt(2).setIcon(R.drawable.baseline_apps_24);
//        tabLayout.getTabAt(3).setIcon(R.drawable.baseline_mediation_24);
//        tabLayout.getTabAt(4).setIcon(R.drawable.baseline_favorite_24);
//        tabLayout.getTabAt(5).setIcon(R.drawable.baseline_menu_24);
//
//    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int item_id = item.getItemId();

        if (item_id == R.id.menu_item1){
            LoadFragment(new FavouriteFragment());
        }
        if (item_id == R.id.menu_item2){
            LoadFragment(new SettingsFragment());
        }
        if (item_id == R.id.menu_item3){
            LoadFragment(new LogoutFragment());
        }

        return super.onOptionsItemSelected(item);
    }

    private void LoadFragment(Fragment fragment) {

        FragmentManager fm1 = getSupportFragmentManager();
        FragmentTransaction ft = fm1.beginTransaction();
        ft.replace(R.id.container,fragment).commit();

    }
}