package com.example.parkedapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileClient extends AppCompatActivity {
    ClientsDatabase mydatabase;
    TextView profile_name, profile_description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_client);
        mydatabase= new ClientsDatabase(this);
        profile_name = findViewById(R.id.profile_name);
        profile_description = findViewById(R.id.profile_description);
        //writeDataToProfile();
    }

    public  void writeDataToProfile(){
        // Get Id From Last Page
        Intent in = getIntent();
        Bundle data = in.getExtras();
        int id= Integer.parseInt(data.getString("id"));

        Cursor res = mydatabase.getProfile(id);

        while (res.moveToNext()){
            profile_name.setText(res.getString(2));
            profile_description.setText(res.getString(1));
        }
    }
}
