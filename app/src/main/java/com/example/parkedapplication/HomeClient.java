package com.example.parkedapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeClient extends AppCompatActivity {

    private Button toTicketPage, toCarsPage, toNewParking;
    private TextView toProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_client);

        toTicketPage = (Button)findViewById(R.id.go_to_tickets_page);
        toCarsPage = (Button)findViewById(R.id.go_to_cars_page);
        toNewParking = (Button) findViewById(R.id.go_to_parking_page);
        toProfile = (TextView)findViewById(R.id.home_to_profile);

        toTicketPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeClient.this, TicketsClient.class);
                startActivity(intent);
                finish();
            }
        });
        toProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeClient.this, ProfileClient.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
