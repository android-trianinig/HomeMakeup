package com.training.apps.makeup.ui.signUpAndLogin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bumptech.glide.Glide;
import com.training.apps.makeup.R;
import com.training.apps.makeup.databinding.ActivityStatingBinding;
import com.training.apps.makeup.model.Client;
import com.training.apps.makeup.model.MyProvider;
import com.training.apps.makeup.ui.map.MapActivity;
import com.training.apps.makeup.ui.main.MainActivity;
import com.training.apps.makeup.ui.signUpAndLogin.signUp.FragmentClientSignUp;
import com.training.apps.makeup.ui.signUpAndLogin.signUp.FragmentProviderSignUp;
import com.training.apps.makeup.ui.signUpAndLogin.signUp.FragmentSignUp;

public class StartingActivity extends AppCompatActivity implements IStartingActivityClickHandler {
    private static final String TAG = "StartingActivity";

    private FragmentManager fragmentManager;
    private FragmentSignIn fragmentSignIn;

    private FragmentSignUp fragment_sign_up;
    private int fragment_count = 0;
    private ActivityStatingBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_stating);

        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            DisplayFragmentSignIn();
        }
    }

    public void DisplayFragmentSignIn() {
        fragment_count += 1;
        fragmentSignIn = FragmentSignIn.newInstance();
        if (fragmentSignIn.isAdded()) {
            fragmentManager.beginTransaction().show(fragmentSignIn).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragmentSignIn, "fragmentSignIn").addToBackStack("fragmentSignIn").commit();
        }
    }

    public void displayFragmentSignUp() {
        fragment_count += 1;
        fragment_sign_up = FragmentSignUp.newInstance();
        if (fragment_sign_up.isAdded()) {
            fragmentManager.beginTransaction()
//                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .show(fragment_sign_up)
                    .commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment_sign_up, "fragment_sign_up").addToBackStack("fragment_sign_up").commit();
        }
    }

    @Override
    public void onBackPressed() {
        Back();
    }

    public void Back() {

        if (fragment_count > 1) {
            fragment_count -= 1;
            super.onBackPressed();


        } else {

            finish();

        }

    }

    @Override
    public void onSingUpClickHandler() {
        displayFragmentSignUp();
    }

    @Override
    public void onSignInClickHandler(String phoneNumber, String password) {
        Toast.makeText(this,
                "phone: " + phoneNumber + ", password: " + password,
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onSkipClickHandler() {
        finish();
        Intent mainActivityIntent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(mainActivityIntent);
    }

    @Override
    public void onNewClientSignUpClickHandler(Client client) {
        Toast.makeText(this,
                "name: " + client.getClientName() + ", password: " + client.getClientPassword() + " " + client.getClientCity(),
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void selectClientImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), FragmentClientSignUp.PICK_IMAGE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        FragmentSignUp fragmentSignUp = (FragmentSignUp) fragmentManager.findFragmentByTag("fragment_sign_up");

        if (fragmentSignUp != null) {
            FragmentPagerAdapter a = (FragmentPagerAdapter) fragmentSignUp.mBinding.pager.getAdapter();
            FragmentClientSignUp fCSignUp = (FragmentClientSignUp) a.instantiateItem(fragmentSignUp.mBinding.pager, 1);
            FragmentProviderSignUp fVSignUp = (FragmentProviderSignUp) a.instantiateItem(fragmentSignUp.mBinding.pager, 0);


            if (requestCode == FragmentClientSignUp.PICK_IMAGE) {
                if (resultCode == RESULT_OK) {
                    if (data != null) {
//                    try {
//                        InputStream inputStream = getContext().getContentResolver().openInputStream(data.getData());
                        Uri selectedImage = data.getData();

                        fCSignUp.mBinding.txtAddPhoto.setVisibility(View.GONE);
                        Glide.with(this).load(selectedImage)
                                .into(fCSignUp.mBinding.imgUser);
                    }
//
////                Bitmap userPhoto = BitmapFactory.decodeStream(inputStream);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
                }
            } else if (requestCode == FragmentClientSignUp.PICK_ADDRESS) {
                if (resultCode == RESULT_OK) {
                    if (data != null) {
                        String address = data.getStringExtra("user_address");
                        if (address != null) {
                            fCSignUp.mBinding.txtClientLocation.setText(address);

                        }
                    }
                }
            } else if (requestCode == FragmentProviderSignUp.PICK_IMAGE) {
                if (resultCode == RESULT_OK) {
                    if (data != null) {
//
                        Uri selectedImage = data.getData();

                        fVSignUp.mBinding.txtAddPhoto.setVisibility(View.GONE);
                        Glide.with(this).load(selectedImage)
                                .into(fVSignUp.mBinding.imgUserPro);
                    }
                }
            } else if (requestCode == FragmentProviderSignUp.PICK_ADDRESS) {
                if (resultCode == RESULT_OK) {
                    if (data != null) {
                        String address = data.getStringExtra("user_address");
                        if (address != null) {
                            fVSignUp.mBinding.txtProLocation.setText(address);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void getClientLocation() {
        Intent mapIntent = new Intent(getBaseContext(), MapActivity.class);
        startActivityForResult(mapIntent, FragmentClientSignUp.PICK_ADDRESS);
    }


    @Override
    public void selectProviderImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), FragmentProviderSignUp.PICK_IMAGE);
    }

    @Override
    public void getProviderLocation() {
        Intent mapIntent = new Intent(getBaseContext(), MapActivity.class);
        startActivityForResult(mapIntent, FragmentProviderSignUp.PICK_ADDRESS);
    }

    @Override
    public void onNewProviderSignUpClickHandler(MyProvider myProvider) {
        Toast.makeText(this,
                "name: " +
                        myProvider.getProviderName() +
                        ", password: " +
                        myProvider.getProviderPassword() +
                        " " + myProvider.getProviderCity() +
                        " " + myProvider.getProviderLocation(),
                Toast.LENGTH_SHORT)
                .show();
    }
}
