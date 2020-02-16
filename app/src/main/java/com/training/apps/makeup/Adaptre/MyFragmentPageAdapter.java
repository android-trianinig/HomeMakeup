package com.training.apps.makeup.Adaptre;


import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.training.apps.makeup.ui.main.clientProvider.Fragment_ProviderServices;

import java.util.ArrayList;
import java.util.List;

public class MyFragmentPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> titles;

    public MyFragmentPageAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
        titles = new ArrayList<>();
    }

    public void addFragments(List<Fragment> fragmentList) {
        this.fragmentList.addAll(fragmentList);

    }


    public void addTitles(List<String> titles) {
        this.titles.addAll(titles);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if (position == 0) {
            //
        }
        return super.instantiateItem(container, position);
    }

    @Override
    @NonNull
    public Fragment getItem(int position) {
        Log.e("adapter", "getItem: called" + position);
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);

    }

}
