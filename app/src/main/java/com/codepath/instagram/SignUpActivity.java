package com.codepath.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG = "SignUpActivity";
    private EditText edtUsernameNew;
    private EditText edtPasswordNew;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtUsernameNew = findViewById(R.id.edtUsernameNew);
        edtPasswordNew = findViewById(R.id.edtPasswordNew);
        btnCreate = findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        if(edtUsernameNew.getText().toString().isEmpty()){
            Toast.makeText(SignUpActivity.this, "You must have a valid username", Toast.LENGTH_SHORT).show();
        }else {
            user.setUsername(edtUsernameNew.getText().toString());
        }
        if(edtPasswordNew.getText().toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Your password cannot be empty", Toast.LENGTH_SHORT).show();
        }else{
            user.setPassword(edtPasswordNew.getText().toString());
        }
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {

            public void done(ParseException e) {
                if (e == null) {
                    goToLogin();
                } else {
                    Log.e(TAG, "Sign up did not succeed", e);
                }
            }
        });
        goToLogin();
            }
        });
    }

    void goToLogin(){
        Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(i);
    }
}