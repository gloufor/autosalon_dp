package com.example.autosalon_bashkirov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class services_main extends AppCompatActivity {

    private ImageView iv_back_button;

    private Button buttonAcsessuary;

    private Button buttonZapchasti;

    private Button buttonTexOsmotr;

    private Button buttonRemont;

    private Button buttonAcsessuaryCpec;

    private Button admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_main);

        iv_back_button = findViewById(R.id.iv_back_button1);
        buttonAcsessuary = findViewById(R.id.buttonAcsessuary);
        buttonZapchasti = findViewById(R.id.buttonZapchasti);
        buttonTexOsmotr = findViewById(R.id.buttonTexOsmotr);
        buttonRemont = findViewById(R.id.buttonRemont);
        buttonAcsessuaryCpec = findViewById(R.id.buttonAcsessuaryCpec);
        admin = findViewById(R.id.admin);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(services_main.this, admins_main.class);
                startActivity(intent);
            }
        });

        iv_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(services_main.this, news_main.class);
                startActivity(intent);
            }
        });

        buttonAcsessuary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(services_main.this, accessoriess_main.class);
                startActivity(intent);
            }
        });

        buttonZapchasti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(services_main.this, zapchasty_main.class);
                startActivity(intent);
            }
        });

        buttonTexOsmotr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(services_main.this, technical_inspection_main.class);
                startActivity(intent);
            }
        });

        buttonRemont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(services_main.this, repair_main.class);
                startActivity(intent);
            }
        });

        buttonAcsessuaryCpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(services_main.this, collectible_accessories_main.class);
                startActivity(intent);
            }
        });
    }
}