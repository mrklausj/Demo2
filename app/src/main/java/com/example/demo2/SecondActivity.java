package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button btnClose;

    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnClose = findViewById(R.id.btnClose);

        txtMessage = findViewById(R.id.txtmessage);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msgFromMain");

        txtMessage.setText(msg);

        btnClose.setOnClickListener(v -> {
            finish();
        });
    }
}