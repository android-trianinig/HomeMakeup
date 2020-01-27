package com.training.apps.makeup.ui.signUpAndLoginِ;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.fragment.app.FragmentManager;

import com.training.apps.makeup.R;

public class StartingActivity extends AppCompatActivity  {

    private FragmentManager fragmentManager;
    private FragmentSignIn fragmentSignIn;

    private FragmentSignUp fragment_sign_up;
    private int fragment_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stating);


        fragmentManager = getSupportFragmentManager();
        if(savedInstanceState==null){
        DisplayFragmentSignIn();}
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

    public void DisplayFragmentSignUp() {
        fragment_count += 1;
        fragment_sign_up = FragmentSignUp.newInstance();
        if (fragment_sign_up.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_sign_up).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment_sign_up, "fragment_sign_up").addToBackStack("fragment_sign_up").commit();
        }
    }
    @Override
    public void onBackPressed() {
        Back();
    }

    public void Back() {

            if (fragment_count >1) {
                fragment_count -= 1;
                super.onBackPressed();


            } else  {

                finish();

            }



    }
}
