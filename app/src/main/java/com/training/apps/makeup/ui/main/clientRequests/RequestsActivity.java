package com.training.apps.makeup.ui.main.clientRequests;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.training.apps.makeup.Adaptre.MyFragmentPageAdapter;
import com.training.apps.makeup.R;
import com.training.apps.makeup.databinding.ActivityRequestsBinding;

import java.util.ArrayList;
import java.util.List;


public class RequestsActivity extends AppCompatActivity {

    public ActivityRequestsBinding mBinding;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private MyFragmentPageAdapter myRequestsPagerAdapter;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_requests);

        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setTitle(getString(R.string.activity_requests_title));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentList = new ArrayList<>();
        titles = new ArrayList<>();
        myRequestsPagerAdapter = new MyFragmentPageAdapter(getSupportFragmentManager());
        intitFragmentsPage();

        myRequestsPagerAdapter.addFragments(fragmentList);
        myRequestsPagerAdapter.addTitles(titles);
        mBinding.reqPager.setAdapter(myRequestsPagerAdapter);
        mBinding.reqTab.setupWithViewPager(mBinding.reqPager);

        setupTab();

    }

    private void setupTab() {
        ViewGroup.LayoutParams layoutParams = new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        TextView leftTab = (TextView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.left_tab, null);
        leftTab.setText("Previous Requests");
        leftTab.setLayoutParams(layoutParams);
        mBinding.reqTab.getTabAt(0).setCustomView(leftTab);

        TextView rightTab = (TextView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.right_tab, null);
        rightTab.setText("Current Requests");
        rightTab.setLayoutParams(layoutParams);
        mBinding.reqTab.getTabAt(1).setCustomView(rightTab);
    }


    private void intitFragmentsPage() {

        fragmentList.add(Fragment_PreviousRequests.newInstance());
        fragmentList.add(Fragment_CurrentRequests.newInstance());


        titles.add(getString(R.string.previous_requests_title));
        titles.add(getString(R.string.current_requests_title));
    }
}
