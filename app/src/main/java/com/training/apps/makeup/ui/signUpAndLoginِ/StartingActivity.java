package com.training.apps.makeup.ui.signUpAndLoginِ;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.fragment.app.FragmentManager;

import com.training.apps.makeup.R;
import com.training.apps.makeup.ui.signUpAndLoginِ.SignInFragment.OnSignUpButtonClicked;

public class StartingActivity extends AppCompatActivity implements OnSignUpButtonClicked {

    private FragmentManager fragmentManager;
    private SignInFragment signInFragment;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stating);


        fragmentManager = getSupportFragmentManager();
        signInFragment = new SignInFragment();

        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, signInFragment, "sign_in")
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .commit();

    }


    @Override
    public void openSignUpFragment() {
        count++;
        fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .hide(signInFragment)
                .commit();

        SignUpBaseFragment baseFragment = (SignUpBaseFragment) fragmentManager.findFragmentByTag("sign_up");
        if (baseFragment != null) {
            fragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .show(baseFragment)
                    .commit();
        } else {
            baseFragment = new SignUpBaseFragment();
            fragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .add(R.id.fragment_container, baseFragment, "sign_up")
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (count > 0) {
            SignUpBaseFragment baseFragment = (SignUpBaseFragment) fragmentManager.findFragmentByTag("sign_up");
            if (baseFragment != null) {
                fragmentManager.beginTransaction()
                        .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                        .hide(baseFragment)
                        .commit();
            }
            SignInFragment signInFragment = (SignInFragment) fragmentManager.findFragmentByTag("sign_in");
            if (signInFragment != null) {
                fragmentManager.beginTransaction()
                        .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                        .show(signInFragment)
                        .commit();
            }
            count--;
        } else {
            NavUtils.navigateUpFromSameTask(this);
        }
    }
}
