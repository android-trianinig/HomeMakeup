package com.training.apps.makeup.ui.main;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.training.apps.makeup.Adaptre.ServiceRecycleAdapter;
import com.training.apps.makeup.Adaptre.SliderPagerAdapter;
import com.training.apps.makeup.R;
import com.training.apps.makeup.model.MyService;
import com.training.apps.makeup.model.Offer;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private List<Offer> offers;
    private List<MyService> services;
    private ViewPager pager;
    private SliderPagerAdapter adapter;
    private RecyclerView servicesTitleRec;
    private ServiceRecycleAdapter serviceRecycleAdapter;


    public HomeFragment(List<Offer> offers, List<MyService> services) {
        this.offers = offers;
        this.services = services;
    }

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        pager = view.findViewById(R.id.home_slider);
        adapter = new SliderPagerAdapter(offers, getContext());
        pager.setAdapter(adapter);


        servicesTitleRec = view.findViewById(R.id.rec_service_titles);
        servicesTitleRec.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        servicesTitleRec.setHasFixedSize(true);
        serviceRecycleAdapter = new ServiceRecycleAdapter(getContext());
        serviceRecycleAdapter.setMyServices(services);
        servicesTitleRec.setAdapter(serviceRecycleAdapter);

        return view;

    }



}
