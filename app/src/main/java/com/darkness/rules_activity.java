package com.darkness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;

import android.os.Bundle;
import android.widget.ImageButton;

import java.io.IOException;

public class rules_activity extends AppCompatActivity {

    ImageButton Exit;
    MediaPlayer med;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        med = MediaPlayer.create(rules_activity.this, R.raw.buttonmenu);

        med.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer med) {
                med.stop();
                try {
                    med.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Exit = findViewById(R.id.exitRules);

        Exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                med.start();
                startActivity(new Intent(rules_activity.this, MainActivity.class));
            }
        });
    }
}