
package com.example.workwise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginprueba extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    Button signup_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginprueba);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signup_btn = findViewById(R.id.signup_btn);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                    Intent intent = new Intent(loginprueba.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(loginprueba.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(loginprueba.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginprueba.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
