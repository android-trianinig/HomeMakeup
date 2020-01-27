package com.training.apps.makeup.Adaptre;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.training.apps.makeup.ui.signUpAndLoginِ.*;

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                 return new ClientSignUpFragment();
            case 1:
            default:
                return new ProviderSignUpFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "I'am Client";
            case 1:
                return "I'am Service Provider";
            default:
                return "";
        }
    }
}
