package com.training.apps.makeup.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    private List<Offer> offerList;
    private List<MyService> myServiceList;
    private List<MyProvider> myProviders;
    private int counter = 0;

    @BindView(R.id.nav_home)
    LinearLayout home;

    @BindView(R.id.nav_personal_page)
    LinearLayout personalPage;

    @BindView(R.id.nav_notification)
    LinearLayout notification;

    @BindView(R.id.nav_my_requests)
    LinearLayout myRequests;

    @BindView(R.id.nav_call_us)
    LinearLayout callUs;

    @BindView(R.id.nav_terms_and_conditions)
    LinearLayout termsAndCondition;

    @BindView(R.id.nav_exit)
    LinearLayout exit;

    @BindView(R.id.nav_lang)
    RelativeLayout lang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        home.setOnClickListener(this);
        personalPage.setOnClickListener(this);
        notification.setOnClickListener(this);
        myRequests.setOnClickListener(this);
        callUs.setOnClickListener(this);
        termsAndCondition.setOnClickListener(this);
        exit.setOnClickListener(this);

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
            setSelectedItemColor(R.id.nav_home);
            counter = 0;
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);

        } else super.onBackPressed();
    }


    @Override
    public void onClick(View v) {
        setAllItemsBackgroundToDefault();
        switch (v.getId()) {
            case R.id.nav_home:
                if (counter != 0) {
                    setSelectedItemColor(v.getId());
                    counter = 0;
                    fragmentManager.
                            beginTransaction()
                            .replace(R.id.fragment_container_drw, new HomeFragment(offerList, myServiceList, myProviders)).commit();
                }
                break;

            case R.id.nav_personal_page:
                if (counter != 1) {
                    setSelectedItemColor(v.getId());
                    counter = 1;
                    fragmentManager.
                            beginTransaction()
                            .replace(R.id.fragment_container_drw, new PersonalPageFragment()).commit();
                }
                break;
            case R.id.nav_notification:
                if (counter != 2) {
                    counter = 2;
                    setSelectedItemColor(v.getId());
                    fragmentManager.
                            beginTransaction()
                            .replace(R.id.fragment_container_drw, new NotificationFragment()).commit();
                }
                break;
            case R.id.nav_my_requests:
                if (counter != 3) {
                    counter = 3;
                    setSelectedItemColor(v.getId());
                    fragmentManager.
                            beginTransaction()
                            .replace(R.id.fragment_container_drw, new MyRequestsFragment()).commit();
                }
                break;
            case R.id.nav_call_us:
                if (counter != 4) {
                    counter = 4;
                    setSelectedItemColor(v.getId());
                    fragmentManager.
                            beginTransaction()
                            .replace(R.id.fragment_container_drw, new CallUsFragment()).commit();
                }
                break;
            case R.id.nav_terms_and_conditions:
                if (counter != 5) {
                    counter = 5;
                    setSelectedItemColor(v.getId());
                    fragmentManager.
                            beginTransaction()
                            .replace(R.id.fragment_container_drw, new TermsAndConditionFragment()).commit();
                }
                break;

            default:
                finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    void setSelectedItemColor(int itemId) {
        View view = findViewById(itemId);
        view.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
    }

    void setAllItemsBackgroundToDefault() {
        home.setBackgroundResource(R.drawable.nav_selector);
        personalPage.setBackgroundResource(R.drawable.nav_selector);
        notification.setBackgroundResource(R.drawable.nav_selector);
        myRequests.setBackgroundResource(R.drawable.nav_selector);
        callUs.setBackgroundResource(R.drawable.nav_selector);
        termsAndCondition.setBackgroundResource(R.drawable.nav_selector);
    }

}

