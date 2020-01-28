package com.training.apps.makeup.ui.signUpAndLogin;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.training.apps.makeup.Adaptre.PageAdapter;
import com.training.apps.makeup.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignUp extends Fragment {


    private PageAdapter pageAdapter;
    private ViewPager pager;
    private TabLayout tabLayout;
    private List<Fragment> fragmentList;
    private List<String> titles;

    public static FragmentSignUp newInstance() {
        return new FragmentSignUp();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_base_sign_up, container, false);
        fragmentList = new ArrayList<>();
        titles = new ArrayList<>();
        pager = view.findViewById(R.id.pager);
        pageAdapter = new PageAdapter(getChildFragmentManager());
        intitfragmentspage();

        pageAdapter.addfragments(fragmentList);
        pageAdapter.addTitles(titles);
        pager.setAdapter(pageAdapter);
        tabLayout = view.findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

        return view;
    }

    private void intitfragmentspage() {

        fragmentList.add(FragmentProviderSignUp.newInstance());
        fragmentList.add(FragmentClientSignUp.newInstance());


        titles.add(getString(R.string.provider));
        titles.add(getString(R.string.client));
    }
}
