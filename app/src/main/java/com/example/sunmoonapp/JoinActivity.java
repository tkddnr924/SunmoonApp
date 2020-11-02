package com.example.sunmoonapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class JoinActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_join);
    }

    public void joinUser (View v) {
        String userID = ((EditText) findViewById(R.id.et_userid)).getText().toString();
        String userPW = ((EditText) findViewById(R.id.et_userPassword)).getText().toString();
        String userEmail = ((EditText) findViewById(R.id.et_userEmail)).getText().toString();
        String userName = ((EditText) findViewById(R.id.et_userName)).getText().toString();
        String userNickName = ((EditText) findViewById(R.id.et_userNickName)).getText().toString();

        if (userID.equals("")) {
            Toast.makeText(this, "ID is Required!", Toast.LENGTH_LONG).show();
            findViewById(R.id.et_userid).requestFocus();
            return;
        }

        if (userPW.equals("")) {
            Toast.makeText(this, "Password is Required!", Toast.LENGTH_LONG).show();
            findViewById(R.id.et_userPassword).requestFocus();
            return;
        }

        if (userEmail.equals("")) {
            Toast.makeText(this, "E-Mail is Required!", Toast.LENGTH_LONG).show();
            findViewById(R.id.et_userEmail).requestFocus();
            return;
        }

        if (userName.equals("")) {
            Toast.makeText(this, "Name is Required!", Toast.LENGTH_LONG).show();
            findViewById(R.id.et_userName).requestFocus();
            return;
        }

        if (userNickName.equals("")) {
            Toast.makeText(this, "NickName is Required!", Toast.LENGTH_LONG).show();
            findViewById(R.id.et_userNickName).requestFocus();
            return;
        }

        Toast.makeText(this, "OK!", Toast.LENGTH_LONG).show();

        // Firebase ...

    }
    public void cancel (View v) {
        finish();
    }
}
