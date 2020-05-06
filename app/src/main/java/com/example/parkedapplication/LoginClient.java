package com.example.parkedapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginClient extends AppCompatActivity {
    ClientsDatabase mydatabase;
    private Button login_btn, registerBtn;
    EditText phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_client);
        mydatabase= new ClientsDatabase(this);
        login_btn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydatabase.login(phone.getText().toString(), password.getText().toString());

                if (res.getCount()==0){
                    Toast.makeText(LoginClient.this,"Invalid Login Details",Toast.LENGTH_LONG).show();
                }else {
                    while (res.moveToNext()){
                        // Create bundle of ID that will be used to get data on client Profile
                        Bundle data = new Bundle();
                        data.putString("id", String.valueOf(res.getString(0)));
                        Intent intent = new Intent(LoginClient.this, ProfileClient.class);
                        intent.putExtras(data);
                        startActivity(intent);
                        finish();
                    }

                }

            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginClient.this, SignUpClient.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
