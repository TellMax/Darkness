package com.darkness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.IOException;

public class choise_activity extends AppCompatActivity {

    ImageButton easy;
    ImageButton hard;
    MediaPlayer med;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        med = MediaPlayer.create(choise_activity.this, R.raw.e);

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
        setContentView(R.layout.choise);
        easy();
        hard();
    }

    protected void easy()
    {
        easy = findViewById(R.id.easy);

        easy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int i = 1;
                med.start();
                Intent uiu = new Intent(choise_activity.this, Game_proces.class);
                uiu.putExtra("Choice", i);
                startActivity(uiu);
            }
        });
    }

    protected void hard()
    {
        hard = findViewById(R.id.hard);

        hard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int i = 2;
                med.start();
                Intent uiu = new Intent(choise_activity.this, Game_proces.class);
                uiu.putExtra("Choice", i);
                startActivity(uiu);
            }
        });
    }
}