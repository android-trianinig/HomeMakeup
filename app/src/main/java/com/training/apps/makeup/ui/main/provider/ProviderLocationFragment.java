package com.training.apps.makeup.ui.main.provider;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.training.apps.makeup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProviderLocationFragment extends Fragment {


    public ProviderLocationFragment() {
        // Required empty public constructor
    }

    public static ProviderLocationFragment getInstance() {
        return new ProviderLocationFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_provider_location, container, false);
    }

}
