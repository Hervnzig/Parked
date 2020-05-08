package com.example.parkedapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AgentDashboard extends AppCompatActivity {
    Button btn_create_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_dashboard);
        btn_create_ticket = findViewById(R.id.btn_create_ticket);
        btn_create_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgentDashboard.this, OcrCaptureActivity.class);
                startActivity(intent);

            }
        });
    }

    public void carCheckIn() {

    }

}
