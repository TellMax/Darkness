package com.darkness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.ImageButton;

public class Game_proces extends AppCompatActivity {

    ImageButton Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_proces);

        Exit = findViewById(R.id.exit);

        Exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Game_proces.this, MainActivity.class));
            }
        });
    }
}