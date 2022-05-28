package com.darkness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class EndScreenActivity extends AppCompatActivity {

    ImageButton NewGame;
    ImageButton MainMenu;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        int score = getIntent().getIntExtra("Scores",0);

        NewGame = findViewById(R.id.NewGame);
        MainMenu = findViewById(R.id.MainMenu);
        txt = findViewById(R.id.txt);

        StringBuilder pep = new StringBuilder();
        pep.append("Вы продержались ").append(score).append(" ходов");
        txt.setText(pep);

        NewGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(EndScreenActivity.this, choise_activity.class));
            }
        });

        MainMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(EndScreenActivity.this, MainActivity.class));
            }
        });
    }
}