package com.example.parkedapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpClient extends AppCompatActivity {
    ClientsDatabase mydatabase;
    Button savebtn;
    EditText phoneText, nameText, id_number, emailText, passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_client);
        mydatabase= new ClientsDatabase(this);
        phoneText= (EditText) findViewById(R.id.phone);
        nameText= (EditText) findViewById(R.id.name);
        id_number= (EditText) findViewById(R.id.id_number);
        emailText= (EditText) findViewById(R.id.email);
        passwordText= (EditText) findViewById(R.id.password);
        savebtn= (Button) findViewById(R.id.sign_btn);
        register();
    }

    public void register(){
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long result= mydatabase.clientRegistration(phoneText.getText().toString(),
                        nameText.getText().toString(),id_number.getText().toString(),
                        emailText.getText().toString(),passwordText.getText().toString());
                if(result!=-1){
                    // Create bundle of ID that will be used to get data on client Profile
                    Bundle data = new Bundle();
                    data.putString("id", String.valueOf(result));
                    Intent intent = new Intent(SignUpClient.this, HomeClient.class);
                    intent.putExtras(data);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(SignUpClient.this,"Failed to save",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
