package com.winsion.voiceview;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private VoiceView btnVoiceRight;
    private VoiceView btnVoiceLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = new File(Environment.getExternalStorageDirectory(), "test.wav");
        btnVoiceRight = (VoiceView) findViewById(R.id.btn_voice_right);
        btnVoiceRight.setSide(VoiceView.RIGHT);
        btnVoiceRight.setVoiceFileDir(file.getAbsolutePath());

        File file1 = new File(Environment.getExternalStorageDirectory(), "18800191.aac");
        btnVoiceLeft = (VoiceView) findViewById(R.id.btn_voice_left);
        btnVoiceLeft.setSide(VoiceView.LEFT);
        btnVoiceLeft.setVoiceFileDir(file1.getAbsolutePath());
    }
}
