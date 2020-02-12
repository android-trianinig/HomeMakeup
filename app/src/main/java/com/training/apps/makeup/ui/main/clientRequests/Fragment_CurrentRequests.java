package com.training.apps.makeup.ui.main.clientRequests;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.training.apps.makeup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_CurrentRequests extends Fragment {


    public Fragment_CurrentRequests() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new Fragment_CurrentRequests();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_requests, container, false);
    }

}
