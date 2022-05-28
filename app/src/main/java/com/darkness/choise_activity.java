package com.darkness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class choise_activity extends AppCompatActivity {

    ImageButton easy;
    ImageButton hard;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
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

                Intent uiu = new Intent(choise_activity.this, Game_proces.class);
                uiu.putExtra("Choice", i);
                startActivity(uiu);
            }
        });
    }
}