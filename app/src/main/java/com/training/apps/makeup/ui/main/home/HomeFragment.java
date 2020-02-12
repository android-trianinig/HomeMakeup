package com.training.apps.makeup.ui.main.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.training.apps.makeup.Adaptre.ProviderRecycleAdapter;
import com.training.apps.makeup.Adaptre.ServiceRecycleAdapter;
import com.training.apps.makeup.Adaptre.SliderPagerAdapter;
import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.FragmentHomeBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private SliderPagerAdapter adapter;
    private ServiceRecycleAdapter serviceRecycleAdapter;
    private ProviderRecycleAdapter providerRecycleAdapter;
    public FragmentHomeBinding mBinding;
    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentHomeBinding.inflate(inflater);

        adapter = new SliderPagerAdapter(HomeMakeupRepo.myOffers, getContext());
        mBinding.homeSlider.setAdapter(adapter);

        //services recycler view setup
        mBinding.recServiceTitles.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mBinding.recServiceTitles.setHasFixedSize(true);
        serviceRecycleAdapter = new ServiceRecycleAdapter(getContext());
        serviceRecycleAdapter.setMyServices(HomeMakeupRepo.myServices);
        mBinding.recServiceTitles.setAdapter(serviceRecycleAdapter);

        //providers recycler view setup
        mBinding.recProviders.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mBinding.recProviders.setHasFixedSize(true);
        providerRecycleAdapter = new ProviderRecycleAdapter(getContext());
        providerRecycleAdapter.setMyProviders(HomeMakeupRepo.myProviders);
        mBinding.recProviders.setAdapter(providerRecycleAdapter);

        return mBinding.getRoot();
    }


}
