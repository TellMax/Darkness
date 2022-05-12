package com.darkness;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity
{

    Button start;
    Button exit;
    Button rules;

    MediaPlayer med;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        med = MediaPlayer.create(MainActivity.this, R.raw.buttonmenu);

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

        start = findViewById(R.id.buttonStart);

        rules = findViewById(R.id.buttonrules);

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                med.start();

                startActivity(new Intent(MainActivity.this, Game_proces.class));
            }
        });

        rules.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                med.start();
                startActivity(new Intent(MainActivity.this, rules_activity.class));
            }
        });
    }


}