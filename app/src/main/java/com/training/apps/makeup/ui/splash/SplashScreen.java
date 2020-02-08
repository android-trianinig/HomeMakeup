package com.training.apps.makeup.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.training.apps.makeup.R;
import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.model.Client;
import com.training.apps.makeup.ui.main.MainActivity;
import com.training.apps.makeup.ui.signUpAndLogin.StartingActivity;

public class SplashScreen extends AppCompatActivity {


    private static final String IS_SESSION_ACTIVE = "session_statue";
    private VideoView videoView;
    private RelativeLayout relativeLayout;

    //to initialize to repository
    public Client myClient = HomeMakeupRepo.theClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        videoView = findViewById(R.id.videoView);
        relativeLayout = findViewById(R.id.splash_layout);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_video);
        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                startNextActivity();
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity();
            }
        });
        videoView.start();
    }

    private void startNextActivity() {
        if (isFinishing())
            return;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isSessionActive = sharedPreferences.getBoolean(IS_SESSION_ACTIVE, false);
        Intent intent;
        if (isSessionActive) {
            intent = new Intent(this, MainActivity.class);
        } else {
            intent = new Intent(this, StartingActivity.class);
        }
        startActivity(intent);
        finish();
    }
}

