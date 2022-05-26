package com.darkness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.ImageButton;

public class rules_activity extends AppCompatActivity {

    ImageButton Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        Exit = findViewById(R.id.exitRules);

        Exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(rules_activity.this, MainActivity.class));
            }
        });
    }
}