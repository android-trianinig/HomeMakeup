package com.training.apps.makeup.ui.main.clientProvider;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.training.apps.makeup.Adaptre.expandableRecView.ParentAdapter;
import com.training.apps.makeup.R;
import com.training.apps.makeup.databinding.FragmentProviderServicesBinding;
import com.training.apps.makeup.model.CartItem;
import com.training.apps.makeup.model.MyService;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_ProviderServices extends Fragment {

    public FragmentProviderServicesBinding mBinding;
    private List<MyService> myServiceList;

    public Fragment_ProviderServices() {

    }

    public Fragment_ProviderServices(List<MyService> myServices) {
        this.myServiceList = myServices;
    }

    public static Fragment_ProviderServices getInstance() {
        return new Fragment_ProviderServices();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentProviderServicesBinding.inflate(inflater);

        CartItem cartItem = new CartItem();
        mBinding.setCartItem(cartItem);
        ParentAdapter servicesAdapter = new ParentAdapter(getContext(),myServiceList, cartItem);
        mBinding.servicesListRec.setAdapter(servicesAdapter);
        mBinding.servicesListRec.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mBinding.servicesListRec.setHasFixedSize(true);

        mBinding.confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cartItem.getCartItem().size() == 0) {
                    Toast.makeText(getContext(), R.string.cart_is_empty, Toast.LENGTH_SHORT).show();

                } else {
                    //
                }
            }
        });

        return mBinding.getRoot();
    }

}
