package com.example.autosalon_bashkirov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class news_main extends AppCompatActivity {

    private ImageView iv_back_button;
    private FirebaseAuth mAuth;
    private TextView uslugi;
    private TextView car;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        iv_back_button = findViewById(R.id.iv_back_button);
        mAuth = FirebaseAuth.getInstance();
        uslugi = findViewById(R.id.uslugi);
        car = findViewById(R.id.car);

        TextView textViewBack = (TextView) findViewById(R.id.contact);

        uslugi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(news_main.this, services_main.class);
                startActivity(intent);
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(news_main.this, car_main.class);
                startActivity(intent);
            }
        });

        iv_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(news_main.this, main.class);
                startActivity(intent);
            }
        });


        View.OnClickListener oclImageView = new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(news_main.this, contact_main.class);
                startActivity(intent);
            }
        };

        textViewBack.setOnClickListener(oclImageView);

    }
}