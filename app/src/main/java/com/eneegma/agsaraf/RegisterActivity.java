package com.eneegma.agsaraf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username, email, password, repassword;
    Button btn_reg;
    TextView txt_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        btn_reg = findViewById(R.id.btn_reg);
        txt_log = findViewById(R.id.txt_log);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String txt_user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass)) {
                    Toast.makeText(RegisterActivity.this,"All fields are required",Toast.LENGTH_SHORT).show();
                } else if(password.length()<6) {
                    Toast.makeText(RegisterActivity.this,"Password must have 6 characters at least",Toast.LENGTH_SHORT).show();
                } else if(pass.equals(repass)) {
                    Toast.makeText(RegisterActivity.this,"Registered",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, com.eneegma.agsaraf.LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this,"Passwords don't match",Toast.LENGTH_SHORT).show();
                }
            }
        });

        txt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, com.eneegma.agsaraf.LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}