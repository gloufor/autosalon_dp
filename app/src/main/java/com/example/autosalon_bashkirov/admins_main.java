package com.example.autosalon_bashkirov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class admins_main extends AppCompatActivity {
    private ImageView iv_back_button;
    private Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admins_main);

        iv_back_button = findViewById(R.id.iv_back_button15);
        btnBack = findViewById(R.id.btn_adm2);
        final EditText edit_dannye1 = findViewById(R.id.edit_dannye1);
        final EditText edit_dannye2 = findViewById(R.id.edit_dannye2);
        Button btn = findViewById(R.id.btn_submit);
        VstavitYdalitSaveDannye vys = new VstavitYdalitSaveDannye();
        btn.setOnClickListener(v->
        {
            User sv = new User(edit_dannye1.getText().toString(),edit_dannye2.getText().toString());
            vys.add(sv).addOnSuccessListener(suc->{
                Toast.makeText(this, "Запись создана", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });

        });

        iv_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admins_main.this, services_main.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admins_main.this, admins2_main.class);
                startActivity(intent);
            }
        });
    }
}