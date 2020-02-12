package com.training.apps.makeup.ui.signUpAndLogin.signUp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.training.apps.makeup.Adaptre.MyFragmentPageAdapter;
import com.training.apps.makeup.R;
import com.training.apps.makeup.databinding.FragmentBaseSignUpBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignUp extends Fragment {


    private MyFragmentPageAdapter myFragmentPageAdapter;
    private ViewPager pager;
    private TabLayout tabLayout;
    public FragmentBaseSignUpBinding mBinding;
    private List<Fragment> fragmentList;
    private List<String> titles;

    public static FragmentSignUp newInstance() {
        return new FragmentSignUp();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentBaseSignUpBinding.inflate(inflater);
        fragmentList = new ArrayList<>();
        titles = new ArrayList<>();
        pager = mBinding.pager;
        myFragmentPageAdapter = new MyFragmentPageAdapter(getChildFragmentManager());
        intitfragmentspage();

        myFragmentPageAdapter.addFragments(fragmentList);
        myFragmentPageAdapter.addTitles(titles);
        pager.setAdapter(myFragmentPageAdapter);
        tabLayout = mBinding.tab;
        tabLayout.setupWithViewPager(pager);

        return mBinding.getRoot();
    }

    private void intitfragmentspage() {

        fragmentList.add(FragmentProviderSignUp.newInstance());
        fragmentList.add(FragmentClientSignUp.newInstance());


        titles.add(getString(R.string.provider));
        titles.add(getString(R.string.client));
    }
}
