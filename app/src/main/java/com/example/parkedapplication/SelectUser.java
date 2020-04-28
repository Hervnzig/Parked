package com.example.parkedapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SelectUser extends AppCompatActivity {

    private TextView selectClient, selectAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        selectAgent = findViewById(R.id.choose_agent);
        selectClient = findViewById(R.id.choose_client);

        selectAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectUser.this, LoginAgent.class);
                startActivity(intent);
                finish();
            }
        });

        selectClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectUser.this, LoginClient.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
