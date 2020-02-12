package com.training.apps.makeup.ui.main.clientProfile;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.training.apps.makeup.R;
import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.ActivityPersonalPageBinding;
import com.training.apps.makeup.model.Client;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalPageActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int EDIT_PROFILE = 6060;
    public ActivityPersonalPageBinding mBinding;
    private GoogleMap map;
    private SupportMapFragment mapFragment;
    private Client client;
    private Marker userMarker;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_personal_page);

        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        client = HomeMakeupRepo.theClient;

        mBinding.setClient(client);

        setTheTitlesAndIcons();

        mBinding.map.onCreate(savedInstanceState);
        mBinding.map.getMapAsync(this);

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

        showClientLocation();
    }

    private void showClientLocation() {
        LatLng latLng = client.getLatLng();
        userMarker = map.addMarker(new MarkerOptions()
                .position(latLng)
                .draggable(true));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18f));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBinding.map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBinding.map.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.map.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mBinding.map.onLowMemory();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBinding.map.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBinding.map.onStop();
    }

    public void onEditBtnClick(View view) {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivityForResult(intent, EDIT_PROFILE);
    }
}
