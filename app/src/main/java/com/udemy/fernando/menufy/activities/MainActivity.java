package com.udemy.fernando.menufy.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.udemy.fernando.menufy.R;
import com.udemy.fernando.menufy.fragments.AlertsFragment;
import com.udemy.fernando.menufy.fragments.EmailsFragment;
import com.udemy.fernando.menufy.fragments.InfoFragment;

public class MainActivity extends AppCompatActivity{

    NavigationView navView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindComponents();
        setToolbar();
        setNavigationView();
        setDefaultFragment();
    }

    private void bindComponents(){
        navView = findViewById(R.id.navview);
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    private void setToolbar(){
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_burger);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setNavigationView(){

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                boolean beginTransaction = false;
                Fragment fragment = null;
                switch (menuItem.getItemId()){
                    case R.id.mnuAlert:
                        fragment = new AlertsFragment();
                        beginTransaction = true;
                        break;
                    case R.id.mnuEmail:
                        fragment = new EmailsFragment();
                        beginTransaction = true;
                        break;

                    case R.id.mnuInfo:
                        fragment = new InfoFragment();
                        beginTransaction = true;
                }

                if(beginTransaction){
                    changeFragment(fragment, menuItem);
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });

        SwitchCompat switchCompat = (SwitchCompat) navView.getMenu().findItem(R.id.mnuOption).getActionView();
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(MainActivity.this, "Enabled", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Disabled", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void changeFragment(Fragment fragment, MenuItem menuItem){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentFrame, fragment)
                .commit();
        getSupportActionBar().setTitle(menuItem.getTitle());
        menuItem.setChecked(true);
    }

    private void setDefaultFragment(){
        MenuItem menuItem = navView.getMenu().findItem(R.id.mnuAlert);
        changeFragment(new AlertsFragment(), menuItem);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

}
