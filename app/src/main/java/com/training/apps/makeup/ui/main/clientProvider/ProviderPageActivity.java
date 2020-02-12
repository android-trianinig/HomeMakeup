package com.training.apps.makeup.ui.main.clientProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.training.apps.makeup.Adaptre.MyFragmentPageAdapter;
import com.training.apps.makeup.R;
import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.ActivityProviderPageBinding;
import com.training.apps.makeup.model.MyService;

import java.util.ArrayList;
import java.util.List;

public class ProviderPageActivity extends AppCompatActivity {

    private String providerName;
    public ActivityProviderPageBinding mBinding;
    public List<Fragment> fragmentList;
    public List<String> titleList;
    public List<MyService> myServiceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null) {
            providerName = intent.getStringExtra("provider_name");
        }

        myServiceList = HomeMakeupRepo.myServices;
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_provider_page);

        setSupportActionBar(mBinding.providerToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(providerName);

        initFragments();

        MyFragmentPageAdapter adapter = new MyFragmentPageAdapter(getSupportFragmentManager());
        adapter.addFragments(fragmentList);
        adapter.addTitles(titleList);

        mBinding.pagerProvider.setAdapter(adapter);
        mBinding.tabProvider.setupWithViewPager(mBinding.pagerProvider);
    }

    private void initFragments() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment_ProviderServices(myServiceList));
        fragmentList.add(Fragment_ProviderLocation.getInstance());
        fragmentList.add(Fragment_ProviderRates.getInstance());

        titleList = new ArrayList<>();
        titleList.add(getString(R.string.provider_services_list));
        titleList.add(getString(R.string.provider_map_location));
        titleList.add(getString(R.string.provider_rates));
    }
}
