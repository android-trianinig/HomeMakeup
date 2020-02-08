package com.training.apps.makeup.ui.signUpAndLogin;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.training.apps.makeup.databinding.FragmentSignInBinding;
import com.training.apps.makeup.ui.main.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignIn extends Fragment {


    private FragmentSignInBinding mBinding;
    private String mUserPhone;
    private String mUserPassword;


    public static FragmentSignIn newInstance() {
        return new FragmentSignIn();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentSignInBinding.inflate(inflater);
        IStartingActivityClickHandler startingActivityClickHandler = (IStartingActivityClickHandler)getActivity();
        mBinding.setIStartingHandler(startingActivityClickHandler);
        return mBinding.getRoot();
    }

}
