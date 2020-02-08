package com.training.apps.makeup.ui.main.myProfile;


import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.training.apps.makeup.R;
import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.FragmentPersonalPageBinding;
import com.training.apps.makeup.model.Client;
import com.training.apps.makeup.ui.main.IMainClickHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalPageFragment extends Fragment implements OnMapReadyCallback {

    public FragmentPersonalPageBinding mBinding;
    private GoogleMap map;
    private SupportMapFragment mapFragment;
    private Client client;
    private Marker userMarker;


    public PersonalPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentPersonalPageBinding.inflate(inflater);

        client = HomeMakeupRepo.theClient;
        IMainClickHandler iMainClickHandler = (IMainClickHandler) getActivity();

        mBinding.setClient(client);
        mBinding.setIMainClickHandler(iMainClickHandler);

        setTheTitlesAndIcons();

        mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(PersonalPageFragment.this);

        return mBinding.getRoot();
    }

    private void setTheTitlesAndIcons() {

        mBinding.profileName.ic.setBackgroundResource(R.drawable.ic_name);
        mBinding.profileEmail.ic.setBackgroundResource(R.drawable.ic_mail);
        mBinding.profilePhone.ic.setBackgroundResource(R.drawable.ic_phone);
        mBinding.profileCity.ic.setBackgroundResource(R.drawable.ic_city);
        mBinding.profileAddress.ic.setBackgroundResource(R.drawable.ic_address);


        mBinding.profileName.title.setText(getString(R.string.name_profile));
        mBinding.profileEmail.title.setText(getString(R.string.email_profile));
        mBinding.profilePhone.title.setText(getString(R.string.phone_profile));
        mBinding.profileCity.title.setText(getString(R.string.city_profile));
        mBinding.profileAddress.title.setText(getString(R.string.address_profile));

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setAllGesturesEnabled(false);
        map.getUiSettings().setRotateGesturesEnabled(false);
        map.getUiSettings().setTiltGesturesEnabled(false);

        Dexter.withActivity(this.getActivity()).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                showClientLocation();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                Toast.makeText(getContext(), "Permission needed to get your current location", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

            }
        }).check();
    }

    private void showClientLocation() {
        LatLng latLng = client.getLatLng();
        userMarker = map.addMarker(new MarkerOptions()
                .position(latLng)
                .draggable(true));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18f));
    }
}
