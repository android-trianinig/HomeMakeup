package com.training.apps.makeup.ui.main.clientProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.training.apps.makeup.Adaptre.MyFragmentPageAdapter;
import com.training.apps.makeup.R;
import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.ActivityProviderPageBinding;
import com.training.apps.makeup.model.ChildService;
import com.training.apps.makeup.model.MyService;
import com.training.apps.makeup.ui.main.cart.CartActivity;

import java.util.ArrayList;
import java.util.List;

public class ProviderPageActivity extends AppCompatActivity {

    private String providerName;
    public ActivityProviderPageBinding mBinding;
    public List<Fragment> fragmentList;
    public List<String> titleList;
    public List<MyService> myServiceList;
    private Menu menu;


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

    private void changeCartIcon(boolean itemsAdded) {
        if (itemsAdded) {
            menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_cart_updated));
        } else {
            menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_cart));
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.action_bar_menu, menu);

        this.menu = menu;

        HomeMakeupRepo.cartItems.observe(this, new Observer<List<ChildService>>() {
            @Override
            public void onChanged(List<ChildService> childServices) {
                if (childServices.size() > 0) {
                    changeCartIcon(true);
                } else {
                    changeCartIcon(false);
                }
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_open_cart:
                startActivity(new Intent(this, CartActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
