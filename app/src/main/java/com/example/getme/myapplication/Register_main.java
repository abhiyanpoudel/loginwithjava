package com.example.getme.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register_main extends AppCompatActivity {
    EditText name, username, password;
    Button register, login;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_main);
        sp = getSharedPreferences("Userinfo", 0);

        name = findViewById(R.id.entername);
        username = findViewById(R.id.enterusername);
        password = findViewById(R.id.enterpassword);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);




    }

    public void btnClick(View view) {
        if (view.getId() == R.id.register) {
            String namevalue = name.getText().toString();
            String usernamevalue = username.getText().toString();
            String passwordvalue = password.getText().toString();
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("name",namevalue);
            editor.putString("password",passwordvalue);
            editor.putString("username",usernamevalue);
            editor.apply();

        } else if (view.getId() == R.id.login) {
            finish();
        }
    }
}
