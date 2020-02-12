package com.training.apps.makeup.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import com.training.apps.makeup.R;
import com.training.apps.makeup.databinding.ActivityMainBinding;
import com.training.apps.makeup.ui.main.clientProfile.PersonalPageActivity;
import com.training.apps.makeup.ui.main.clientNotifaication.NotificationActivity;
import com.training.apps.makeup.ui.main.clientRequests.RequestsActivity;
import com.training.apps.makeup.ui.main.home.HomeFragment;

public class MainActivity extends AppCompatActivity {


    public ActivityMainBinding mainBinding;
    private FragmentManager manager;
    private HomeFragment homeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(mainBinding.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                mainBinding.drawerLayout,
                mainBinding.toolbar,
                R.string.nav_drawer_open,
                R.string.nav_drawer_closed);

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorPrimaryDark));

        homeFragment = new HomeFragment();
        mainBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        showHomeFragment();

    }


    private void showHomeFragment() {

        if (homeFragment == null) {
            homeFragment = HomeFragment.getInstance();
        }
        manager = getSupportFragmentManager();
        if (homeFragment.isAdded()) {
            manager.beginTransaction().show(homeFragment).commit();
        } else {
            manager.beginTransaction().add(R.id.fragment_container_drw, homeFragment, "HOME_FRAGMENT").commit();
        }
        mainBinding.navHome.setBackgroundColor(getResources().getColor(R.color.yellow));
    }

    @Override
    public void onBackPressed() {
        if (mainBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {

            mainBinding.drawerLayout.closeDrawer(GravityCompat.START);

        } else super.onBackPressed();
    }


    public void onDrawerItemClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.nav_home:
                break;

            case R.id.nav_personal_page:
                intent = new Intent(this, PersonalPageActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_notification:
                intent = new Intent(this, NotificationActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_my_requests:
                intent = new Intent(this, RequestsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_call_us:

                break;
            case R.id.nav_terms_and_conditions:

                break;

            default:
                finish();
        }
        mainBinding.drawerLayout.closeDrawer(GravityCompat.START);
    }


}

