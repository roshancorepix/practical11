package com.example.practical11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    
    EditText et_username,et_pass,et_email;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et_username = findViewById(R.id.et_username);
        et_pass = findViewById(R.id.et_pass);
        et_email = findViewById(R.id.et_email);
        btn_login = findViewById(R.id.btn_login);

        PreferenceManager.init(this);
        
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });
    }

    private void validation() {
        String username = et_username.getText().toString().trim();
        String password = et_pass.getText().toString().trim();
        String email = et_email.getText().toString().trim();

        if (username.isEmpty()){
            et_username.setError("Username is required");
            et_username.requestFocus();
        }else if (password.isEmpty()){
            et_pass.setError("Password is required");
            et_pass.requestFocus();
        }else if (password.length() < 6){
            et_pass.setError("Password is more then 6 character");
            et_pass.requestFocus();
        }else if (email.isEmpty()){
            et_email.setError("Email Address is required");
            et_email.requestFocus();
        }else {
            login(username,password,email);
        }
    }

    private void login(String username, String password, String email) {
        PreferenceManager.setUsername(username);
        PreferenceManager.setPassword(password);
        PreferenceManager.setEmail(email);

        et_username.getText().clear();
        et_email.getText().clear();
        et_pass.getText().clear();

        startActivity(new Intent(MainActivity.this,WelcomeActivity.class));
    }
}