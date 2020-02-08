package com.training.apps.makeup.ui.main.myRequestsFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.training.apps.makeup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentRequestsFragment extends Fragment {


    public CurrentRequestsFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new CurrentRequestsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_requests, container, false);
    }

}
