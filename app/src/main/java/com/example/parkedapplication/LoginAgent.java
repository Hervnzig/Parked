package com.example.parkedapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAgent extends AppCompatActivity {
    AgentsDatabase database;
    private Button agentLoginBtn;
    EditText phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_agent);

        database= new AgentsDatabase(this);
        agentLoginBtn = findViewById(R.id.agentLoginBtn);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);

        agentLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = database.login(phone.getText().toString(), password.getText().toString());

                if (res.getCount()==0){
                    Toast.makeText(LoginAgent.this,"Invalid Login Details",Toast.LENGTH_LONG).show();
                }else {
                    while (res.moveToNext()){
                        // Create bundle of ID that will be used to get data on client Profile
                        Bundle data = new Bundle();
                        data.putString("id", String.valueOf(res.getString(0)));
                        Intent intent = new Intent(LoginAgent.this, ProfileAgent.class);
                        intent.putExtras(data);
                        startActivity(intent);
                        finish();
                    }

                }

            }
        });
    }
}
