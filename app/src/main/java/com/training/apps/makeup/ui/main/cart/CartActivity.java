package com.training.apps.makeup.ui.main.cart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.training.apps.makeup.R;
import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.ActivityCartBinding;
import com.training.apps.makeup.model.ChildService;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    public ActivityCartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_cart);

        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.cart));

        HomeMakeupRepo.cartItems.observe(this, new Observer<List<ChildService>>() {
            @Override
            public void onChanged(List<ChildService> childServices) {
                if (childServices != null) {
                    mBinding.setItemsListLiveData(HomeMakeupRepo.cartItems);
                    mBinding.setItemsCost(getTotalCost(childServices));
                    mBinding.setCurrency(getCurrency(childServices));
                }
            }
        });
    }

    private String getCurrency(List<ChildService> childServices) {

        StringBuilder currency = new StringBuilder();

        if (childServices.size() > 0) {
            currency.append(childServices.get(0).getChildServiceCurrency());
        }
        return currency.toString();
    }

    private int getTotalCost(List<ChildService> childServices) {
        int totalCost = 0;
        for (ChildService ch : childServices) {
            totalCost += ch.getChildServiceCost();
        }
        return totalCost;
    }

}
