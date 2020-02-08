package com.training.apps.makeup.ui.main.provider;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.training.apps.makeup.Adaptre.ProviderPagePagerAdapter;
import com.training.apps.makeup.R;
import com.training.apps.makeup.databinding.ActivityProviderPageBinding;

import java.util.ArrayList;
import java.util.List;

public class ProviderPageActivity extends AppCompatActivity {

    private String providerName;
    public ActivityProviderPageBinding mBinding;
    public List<Fragment> fragmentList;
    public List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null) {
            providerName = intent.getStringExtra("provider_name");
        }

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_provider_page);
        mBinding.providerToolbar.setTitle(providerName);
        setSupportActionBar(mBinding.providerToolbar);

        initFragments();

        ProviderPagePagerAdapter adapter = new ProviderPagePagerAdapter(getSupportFragmentManager());
        adapter.addFragments(fragmentList);
        adapter.addTitles(titleList);

        mBinding.pagerProvider.setAdapter(adapter);
        TabLayout tabLayout = mBinding.tabProvider;
        tabLayout.setupWithViewPager(mBinding.pagerProvider);
    }

    private void initFragments() {
        fragmentList = new ArrayList<>();
        fragmentList.add(ProviderServicesFragment.getInstance());
        fragmentList.add(ProviderLocationFragment.getInstance());
        fragmentList.add(ProviderRatesFragment.getInstance());

        titleList = new ArrayList<>();
        titleList.add(getString(R.string.provider_services_list));
        titleList.add(getString(R.string.provider_map_location));
        titleList.add(getString(R.string.provider_rates));
    }
}
