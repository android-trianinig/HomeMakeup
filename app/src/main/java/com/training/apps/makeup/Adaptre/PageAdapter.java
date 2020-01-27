package com.training.apps.makeup.Adaptre;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> titles;
    public PageAdapter(FragmentManager fm) {
        super(fm);
        fragmentList=new ArrayList<>();
        titles = new ArrayList<>();
    }
public void addfragments(List<Fragment> fragmentList){
        this.fragmentList.addAll(fragmentList);
    //Log.e("kjjj",this.fragmentList.size()+"");


}

    public void addTitles(List<String> titles)
    {
        this.titles.addAll(titles);
    }

    @Override
    public Fragment getItem(int position) {
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
