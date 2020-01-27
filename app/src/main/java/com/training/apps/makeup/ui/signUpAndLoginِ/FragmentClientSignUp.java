package com.training.apps.makeup.ui.signUpAndLoginِ;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.training.apps.makeup.R;
import com.training.apps.makeup.ui.MapActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentClientSignUp extends Fragment {
    private String userType;
    private String mUserName;
    private String mUserPhoneNumber;
    private String mUserEmail;
    private String mUserCityName;
    private String mUserAddress;
    private double mUserCityLat;
    private double mUserCityLong;
    private double mUserLat;
    private double mUserLong;
    private String mUserPassword;
    private BroadcastReceiver broadcastReceiver;


    @BindView(R.id.edt_client_name)
    EditText userNameView;

    @BindView(R.id.edt_client_email)
    EditText userEmailView;

    @BindView(R.id.spinner_client_city)
    Spinner userCitySpinner;

    @BindView(R.id.edt_client_phone)
    EditText userPhoneView;

    @BindView(R.id.edt_client_password)
    EditText userPasswordView;

    @BindView(R.id.txt_client_location)
    TextView userLocationTextView;

    @BindView(R.id.img_user)
    ImageView userImageView;

    @BindView(R.id.txt_add_photo)
    TextView newPhotoTextView;

    @BindView(R.id.new_user_sign_up_btn)
    Button addNewUser;
    private int PICK_IMAGE = 1212;

    public static FragmentClientSignUp newInstance() {
        return new FragmentClientSignUp();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_client_sign_up, container, false);
        ButterKnife.bind(this, view);

        userCitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mUserCityName = (String) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        userLocationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(getContext(), MapActivity.class);
                startActivity(mapIntent);
            }
        });




        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mUserAddress = intent.getStringExtra("userAddress");
                mUserLat = intent.getDoubleExtra("userLat", 0);
                mUserLong = intent.getDoubleExtra("userLong", 0);

                userLocationTextView.setText(mUserAddress);
            }
        };
        LocalBroadcastManager.getInstance(getContext()).
                registerReceiver(broadcastReceiver, new IntentFilter("location-confirmed"));
        userImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.PICK_IMAGE) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
//                    try {
//                        InputStream inputStream = getContext().getContentResolver().openInputStream(data.getData());
                        Uri selectedImage = data.getData();
                        newPhotoTextView.setVisibility(View.GONE);
                        Glide.with(this).load(selectedImage)
                                .into(userImageView);
//                        Bitmap userPhoto = BitmapFactory.decodeStream(inputStream);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(broadcastReceiver);
    }
}
