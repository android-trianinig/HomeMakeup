package com.training.apps.makeup.ui.main.provider;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;

import com.training.apps.makeup.Adaptre.ExpandableServicesListAdapter;
import com.training.apps.makeup.R;
import com.training.apps.makeup.data.HomeMakeupRepo;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProviderServicesFragment extends Fragment {


    public ProviderServicesFragment() {

    }

    public static ProviderServicesFragment getInstance() {
        return new ProviderServicesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_provider_services, container, false);
        ExpandableListView listView = view.findViewById(R.id.provider_exp);

        ExpandableServicesListAdapter adapter = new ExpandableServicesListAdapter(getContext(), HomeMakeupRepo.myServices, HomeMakeupRepo.childServiceMap);

        listView.setAdapter(adapter);

        return view;
    }

}
