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
import com.training.apps.makeup.model.MyProvider;
import com.training.apps.makeup.model.MyService;
import com.training.apps.makeup.model.Offer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    private List<Offer> offerList;
    private List<MyService> myServiceList;
    private List<MyProvider> myProviders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        offerList = new ArrayList<>();
        offerList.add(new Offer("offer1", 1, R.drawable.home_makeup_offer1));
        offerList.add(new Offer("offer2", 2, R.drawable.home_makeup_offer2));
        offerList.add(new Offer("offer3", 3, R.drawable.home_makeup_offer3));
        offerList.add(new Offer("offer4", 4, R.drawable.home_makeup_offer4));

        myServiceList = new ArrayList<>();
        myServiceList.add(new MyService("All"));
        myServiceList.add(new MyService("Henaa"));
        myServiceList.add(new MyService("Body Care"));
        myServiceList.add(new MyService("Hair Cut"));
        myServiceList.add(new MyService("Makeup"));
        myServiceList.add(new MyService("Manicure"));

        myProviders = new ArrayList<>();
        myProviders.add(new MyProvider("Hend Ali", 1, "Alexandria", "Salon/Women", 10, R.drawable.pro1));
        myProviders.add(new MyProvider("Sama Ibrahim", 2, "Cairo", "Salon/Women", 5, R.drawable.pro2));
        myProviders.add(new MyProvider("Haya Helal", 3, "Riyadh", "Salon/Women", 3, R.drawable.pro3));
        myProviders.add(new MyProvider("Zainab El-taweel", 4, "Mecca", "Salon/Women", 8, R.drawable.pro4));
        myProviders.add(new MyProvider("Elahm Ali", 5, "Medina", "Salon/Women", 9, R.drawable.pro5));



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
                    .replace(R.id.fragment_container_drw, new HomeFragment(offerList, myServiceList, myProviders)).commit();
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
                        .replace(R.id.fragment_container_drw, new HomeFragment(offerList, myServiceList, myProviders)).commit();
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
