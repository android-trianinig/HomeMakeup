package com.training.apps.makeup.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.training.apps.makeup.R;
import com.training.apps.makeup.ui.signUpAndLoginِ.HomeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.nav_drawer_open,
                R.string.nav_drawer_closed);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            fragmentManager.
                    beginTransaction()
                    .replace(R.id.fragment_container_drw, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);

        } else super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                fragmentManager.
                        beginTransaction()
                        .replace(R.id.fragment_container_drw, new HomeFragment()).commit();
                break;

            case R.id.nav_personal_page:
                fragmentManager.
                        beginTransaction()
                        .replace(R.id.fragment_container_drw, new PersonalPageFragment()).commit();
                break;
            case R.id.nav_notification:
                fragmentManager.
                        beginTransaction()
                        .replace(R.id.fragment_container_drw, new NotificationFragment()).commit();
                break;
            case R.id.nav_my_requests:
                fragmentManager.
                        beginTransaction()
                        .replace(R.id.fragment_container_drw, new MyRequestsFragment()).commit();
                break;
            case R.id.nav_call_us:
                fragmentManager.
                        beginTransaction()
                        .replace(R.id.fragment_container_drw, new CallUsFragment()).commit();
                break;
            case R.id.nav_terms_and_conditions:
                fragmentManager.
                        beginTransaction()
                        .replace(R.id.fragment_container_drw, new TermsAndConditionFragment()).commit();
                break;
            case R.id.nav_lang:
                //change lang
                break;
            default:
                finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
