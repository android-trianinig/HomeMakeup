package com.training.apps.makeup.ui.main.myRequestsFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.FragmentPreviousRequestsBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreviousRequestsFragment extends Fragment {


    FragmentPreviousRequestsBinding mBinding;

    public PreviousRequestsFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new PreviousRequestsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentPreviousRequestsBinding.inflate(inflater);

        mBinding.setPrevReqList(HomeMakeupRepo.previousRequests);

        return mBinding.getRoot();
    }

}
