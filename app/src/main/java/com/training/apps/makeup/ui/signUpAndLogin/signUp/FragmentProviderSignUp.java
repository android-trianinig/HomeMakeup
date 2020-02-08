package com.training.apps.makeup.ui.signUpAndLogin.signUp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.FragmentProviderSignUpBinding;
import com.training.apps.makeup.model.MyProvider;
import com.training.apps.makeup.ui.signUpAndLogin.IStartingActivityClickHandler;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProviderSignUp extends Fragment {
    public static final int PICK_IMAGE = 7070;
    public static final int PICK_ADDRESS = 6060;
    public FragmentProviderSignUpBinding mBinding;


    public static FragmentProviderSignUp newInstance() {
        return new FragmentProviderSignUp();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = FragmentProviderSignUpBinding.inflate(inflater);
        List<String> cities = HomeMakeupRepo.cities;
        mBinding.setCities(cities);
        mBinding.setPtovider(new MyProvider());
        mBinding.setIStartingActivity((IStartingActivityClickHandler) getActivity());
        return mBinding.getRoot();
    }
}