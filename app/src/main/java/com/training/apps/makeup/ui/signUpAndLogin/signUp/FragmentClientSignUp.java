package com.training.apps.makeup.ui.signUpAndLogin.signUp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.FragmentClientSignUpBinding;
import com.training.apps.makeup.model.Client;
import com.training.apps.makeup.ui.signUpAndLogin.IStartingActivityClickHandler;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentClientSignUp extends Fragment {
    ;
    public FragmentClientSignUpBinding mBinding;

    public static int PICK_IMAGE = 1212;
    public static int PICK_ADDRESS = 1515;


    public static FragmentClientSignUp newInstance() {
        return new FragmentClientSignUp();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentClientSignUpBinding.inflate(inflater);
        List<String> cities = HomeMakeupRepo.cities;
        mBinding.setCities(cities);
        mBinding.setClient(new Client());
        mBinding.setIStartingActivity((IStartingActivityClickHandler)getActivity());

        return mBinding.getRoot();
    }
}
