package com.training.apps.makeup.ui.signUpAndLoginِ;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.training.apps.makeup.R;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {
    @BindView(R.id.edt_phone)
    EditText userPhoneNumber;
    @BindView(R.id.edt_password)
    EditText userPassword;
    @BindView(R.id.btn_sign_in)
    Button btnSignIn;
    @BindView(R.id.btn_sign_up)
    Button btnSignUp;
    @BindView(R.id.btn_skip)
    Button skipBtn;

    private String mUserPhone;
    private String mUserPassword;
    private OnSignUpButtonClicked onSignUpButtonClicked;

    public interface OnSignUpButtonClicked {
        void openSignUpFragment();
    }

    public SignInFragment() {
        // Required empty public constructor
    }
//    public SignInFragment(OnSignUpButtonClicked onSignUpButtonClicked) {
//        this.onSignUpButtonClicked = onSignUpButtonClicked;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, view);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignUpButtonClicked.openSignUpFragment();
            }
        });

        return view;
    }


    public void onLogInBtnClicked(View view) {
        //fot testing only
        mUserPhone = userPhoneNumber.getText().toString();
        mUserPassword = userPassword.getText().toString();
        if ((mUserPhone!= null && !mUserPhone.isEmpty()) && (mUserPassword != null && !mUserPassword.isEmpty())) {
            Toast.makeText(getContext(), "phone: " + mUserPhone + " password: " + mUserPassword, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "please type your phone and password", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            this.onSignUpButtonClicked = (OnSignUpButtonClicked)context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement OnSignUpButtonClicked Interface");
        }
    }

}
