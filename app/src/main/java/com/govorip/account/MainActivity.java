package com.govorip.account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;

    private boolean isEmailValid() {
        return !TextUtils.isEmpty(etEmail.getText())&&
                Patterns.EMAIL_ADDRESS.matcher(etEmail.getText()).matches();
    }

    private boolean isPasswordValid() {
        return !TextUtils.isEmpty(etPassword.getText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmailValid() && isPasswordValid()) {
                    Intent intent = new Intent(MainActivity.this, ActivityB.class);
                    intent.putExtra("email", etEmail.getText().toString());
                    intent.putExtra("password", etPassword.getText().toString());
                    startActivity(intent);
                } else{
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.input_error, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

}
