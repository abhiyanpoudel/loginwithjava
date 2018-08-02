package com.example.getme.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button register, login;
    CheckBox rememberme;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("Userinfo", 0);
        username =findViewById(R.id.enterusername);
        password = findViewById(R.id.enterpassword);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        rememberme = findViewById(R.id.rememberme);
        if (sp.getBoolean("rememberme",false)){
            startActivity(new Intent(MainActivity.this,Main2Activity.class));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameVal = username.getText().toString();
                String passwordVal = password.getText().toString();
                String registerUsername = sp.getString("username","");
                String registerPassword = sp.getString("password","");
                if(usernameVal.equals(registerPassword) && passwordVal.equals(registerPassword)); {
                    Toast.makeText(MainActivity.this,"Login sucess",Toast.LENGTH_SHORT).show();
                    if (rememberme.isChecked()){
                        sp.edit().putBoolean("remberme",true).commit();
                        Toast.makeText(MainActivity.this,"Login sucess",Toast.LENGTH_SHORT).show();
                    }
                    startActivity(new Intent(MainActivity.this,Main2Activity.class));
                    finish();

                }
                }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register_main.class);
                startActivity(intent);
            }
        });
    }
}
