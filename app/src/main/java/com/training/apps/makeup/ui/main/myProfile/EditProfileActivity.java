package com.training.apps.makeup.ui.main.myProfile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.training.apps.makeup.R;
import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.ActivityEditProfileBinding;
import com.training.apps.makeup.model.Client;
import com.training.apps.makeup.ui.map.MapActivity;

import java.util.List;

public class EditProfileActivity extends AppCompatActivity {

    private static final String TAG = "EditProfileActivity";
    private static final int PICK_LOCATION = 8080;
    private ActivityEditProfileBinding mBinding;
    private Client client;
    //LatLng

    private View.OnClickListener onLocationTxtClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(EditProfileActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            startActivityForResult(new Intent(EditProfileActivity.this, MapActivity.class), PICK_LOCATION);
        }
    };

    private View.OnClickListener onConfirmClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HomeMakeupRepo.editClientInfo(client);
            EditProfileActivity.this.finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile);

        List<String> cities = HomeMakeupRepo.cities;
        client = HomeMakeupRepo.theClient;
        mBinding.setCities(cities);
        mBinding.setClient(client);
        mBinding.setOnLocationClickHandler(onLocationTxtClickListener);
        mBinding.setOnConfirmClickHandler(onConfirmClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_LOCATION) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Log.e(TAG, "onActivityResult: " );
                    if (data.getStringExtra("user_address") != null) {
                        String newAddress = data.getStringExtra("user_address");
                        mBinding.editProfileLocation.setText(newAddress);
                    }
                }
            }
        }
    }
}
