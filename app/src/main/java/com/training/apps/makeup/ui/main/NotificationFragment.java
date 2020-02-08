package com.training.apps.makeup.ui.main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.training.apps.makeup.R;
import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.FragmentNotificationBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    private FragmentNotificationBinding mBinding;
    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentNotificationBinding.inflate(inflater);
        mBinding.setNotificationList(HomeMakeupRepo.myNotifications);
        return mBinding.getRoot();
    }

}
