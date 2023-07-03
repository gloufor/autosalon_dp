package com.example.autosalon_bashkirov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class collectible_accessories_main extends AppCompatActivity {

    private ImageView iv_back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectible_accessories_main);

        iv_back_button = findViewById(R.id.iv_back_button14);

        iv_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(collectible_accessories_main.this, services_main.class);
                startActivity(intent);
            }
        });
    }
}