package com.training.apps.makeup.ui.signUpAndLoginِ;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.training.apps.makeup.Adaptre.PagerAdapter;
import com.training.apps.makeup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpBaseFragment extends Fragment {


    public SignUpBaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_base_sign_up, container, false);
        ViewPager pager = view.findViewById(R.id.pager);
        pager.setAdapter(new PagerAdapter(getChildFragmentManager()));

        TabLayout tabLayout = view.findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);
        return view;
    }

}
