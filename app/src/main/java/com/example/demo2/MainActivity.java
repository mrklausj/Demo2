package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkKaffe, chkThe, chkJuice;

    private RadioGroup rgPayment;
    private RadioButton rbCash, rbCreditCard, rbBitcoin;

    private LinearLayout parent;

    private Button btnGoToSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parent = findViewById(R.id.parent);
        chkKaffe = findViewById(R.id.chkKaffe);
        chkThe = findViewById(R.id.chkThe);
        chkJuice = findViewById(R.id.chkJuice);

        rgPayment = findViewById(R.id.rgPayment);
        rbCash = findViewById(R.id.rbCash);
        rbCreditCard = findViewById(R.id.rbCreditCard);
        rbBitcoin = findViewById(R.id.rbBitcoin);

        btnGoToSecond = findViewById(R.id.btnGoToSecond);

        btnGoToSecond.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("msgFromMain","Hilsen fra main");
            startActivity(intent);

        });

        rgPayment.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbCash:
                        System.out.println("Konstant");
                        break;
                    case R.id.rbCreditCard:
                        Log.d("PSL", "Creditcard");
                        break;
                    case R.id.rbBitcoin:
     //                   Toast.makeText(MainActivity.this, "Bitcoin", Toast.LENGTH_SHORT).show();
                        Snackbar.make(parent, "Bitcoin", Snackbar.LENGTH_INDEFINITE)
                                .setAction("Ok", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View View) {}
                                })
                                .show();

                        break;
                }
            }
        });



        chkKaffe.setOnCheckedChangeListener(((compoundButton, b) -> {
            if(b)
                Toast.makeText(MainActivity.this, "Du har valgt Kaffe", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Du har valgt Kaffe fra", Toast.LENGTH_SHORT).show();
        }));

        chkThe.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b)
            Toast.makeText(MainActivity.this, "Du har valgt The", Toast.LENGTH_SHORT).show();

        });

        chkJuice.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b)
            Toast.makeText(MainActivity.this, "Du har valgt Juice", Toast.LENGTH_SHORT).show();
        });
    }
}