package com.training.apps.makeup.ui.signUpAndLogin.signUp;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.training.apps.makeup.databinding.FragmentVerifyPhoneBinding;
import com.training.apps.makeup.ui.main.MainActivity;

import java.util.concurrent.TimeUnit;

public class Fragment_VerifyPhone extends Fragment {

    public FragmentVerifyPhoneBinding mBinding;
    private String phone_number;
    private String verificationId;
    private FirebaseAuth firebaseAuth;

    public Fragment_VerifyPhone() {
        // Required empty public constructor
    }

    public Fragment_VerifyPhone(String phone_number) {
        this.phone_number = phone_number;
    }

    public static Fragment_VerifyPhone newInstance(String phoneNumber) {
        return new Fragment_VerifyPhone(phoneNumber);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentVerifyPhoneBinding.inflate(inflater);

        firebaseAuth = FirebaseAuth.getInstance();

        sendVerificationCode(phone_number);
        mBinding.verifyPhoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable code = mBinding.pinView.getText();
                if (code != null && code.length() == 6) {

                    verifyCode(code.toString());

                } else {
                    mBinding.pinView.setError("Enter valid code");
                    mBinding.pinView.requestFocus();
                }

            }
        });

        return mBinding.getRoot();
    }

    private void verifyCode(String code) {

        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId, code);

        signUpWithCredential(phoneAuthCredential);
    }

    private void signUpWithCredential(PhoneAuthCredential phoneAuthCredential) {

        firebaseAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    startHomeActivity();

                } else {
                    Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void startHomeActivity() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    private void sendVerificationCode(String phoneNumber) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationId = s;


        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                mBinding.pinView.setText(code);
                signUpWithCredential(phoneAuthCredential);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

}

