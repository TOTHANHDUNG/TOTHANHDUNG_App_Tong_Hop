package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_MainActivity extends AppCompatActivity {
    EditText edtEmail,edtPass;
    Button btnLogin,btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);
        edtEmail = (EditText) findViewById(R.id.editTextEmail_login);
        edtPass  = (EditText) findViewById(R.id.editTextPassword_login);
        btnSignup= (Button) findViewById(R.id.buttonSignup_login);
        Button btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login_MainActivity.this, Fashion_Activity.class);
                if (edtEmail.getText().toString().equals("") || edtPass.getText().toString().equals("")) {
                    Toast.makeText(Login_MainActivity.this, "Không được để trống!!", Toast.LENGTH_SHORT).show();
                } else if (edtEmail.getText().toString().equals("dung") && edtPass.getText().toString().equals("123")) {
                    Toast.makeText(Login_MainActivity.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
                    startActivity(i);
                } else {
                    Toast.makeText(Login_MainActivity.this, "Thông tin đăng nhập sai!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_MainActivity.this,SignUp_Activity.class);
                startActivity(intent);
            }
        });
    }
}