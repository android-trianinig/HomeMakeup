package com.training.apps.makeup.ui.main.clientProvider;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.training.apps.makeup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_ProviderLocation extends Fragment {


    public Fragment_ProviderLocation() {
        // Required empty public constructor
    }

    public static Fragment_ProviderLocation getInstance() {
        return new Fragment_ProviderLocation();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_provider_location, container, false);
    }

}
