package com.govorip.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    TextView email_b;
    TextView password_b;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        email_b = findViewById(R.id.email_b);
        password_b = findViewById(R.id.password_b);
        back = findViewById(R.id.back);
        Bundle arg = getIntent().getExtras();
        if (arg != null) {
            String email = arg.get("email").toString();
            String password = arg.get("password").toString();
            email_b.setText(email);
            password_b.setText(password);
        }
    }

    public void back(View view) {
        Intent intent = new Intent(ActivityB.this, MainActivity.class);
        startActivity(intent);
    }
}
