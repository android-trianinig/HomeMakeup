package com.training.apps.makeup.ui.main.myRequestsFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.training.apps.makeup.Adaptre.MyRequestsPagerAdapter;
import com.training.apps.makeup.R;
import com.training.apps.makeup.databinding.FragmentMyRequestsBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyRequestsFragment extends Fragment {

    public FragmentMyRequestsBinding mBinding;
    private List<Fragment> fragmentList;
    private List<String> titles;
    private ViewPager pager;
    private MyRequestsPagerAdapter myRequestsPagerAdapter;
    private TabLayout tabLayout;

    public MyRequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentMyRequestsBinding.inflate(inflater);
        fragmentList = new ArrayList<>();
        titles = new ArrayList<>();
        pager = mBinding.reqPager;
        myRequestsPagerAdapter = new MyRequestsPagerAdapter(getChildFragmentManager());
        intitFragmentsPage();

        myRequestsPagerAdapter.addFragments(fragmentList);
        myRequestsPagerAdapter.addTitles(titles);
        pager.setAdapter(myRequestsPagerAdapter);
        tabLayout = mBinding.reqTab;
        tabLayout.setupWithViewPager(pager);

        return mBinding.getRoot();
    }

    private void intitFragmentsPage() {

        fragmentList.add(PreviousRequestsFragment.newInstance());
        fragmentList.add(CurrentRequestsFragment.newInstance());


        titles.add(getString(R.string.previous_requests_title));
        titles.add(getString(R.string.current_requests_title));
    }
}
