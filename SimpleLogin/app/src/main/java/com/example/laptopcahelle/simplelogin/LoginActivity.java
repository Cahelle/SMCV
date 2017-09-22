package com.example.laptopcahelle.simplelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.UsernameTxt);
        password = (EditText) findViewById(R.id.PasswordTxt);
    }

    public void login(View view) {

        if (username.getText().toString().equals("Cahelle") ){//&& password.getText().toString().equals("abc123")) {
            //correct password
            view.setBackgroundColor(0xFF00FF00);
        }
        else {
            //wrong password
            counter--;

           if(counter==0) {
                //disable the button, close the application e.t.c
                Button btn = (Button) findViewById(R.id.LoginBtn);
                btn.setEnabled(false);

            }
        }
    }
}
