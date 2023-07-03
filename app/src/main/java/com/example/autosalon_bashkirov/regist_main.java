package com.example.autosalon_bashkirov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class regist_main extends AppCompatActivity {

    private EditText email_reg;
    private EditText password_reg;
    private Button buttonReg;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_main);

        mAuth = FirebaseAuth.getInstance();
        email_reg = findViewById(R.id.email_reg);
        password_reg = findViewById(R.id.password_reg);
        buttonReg = findViewById(R.id.buttonReg);

        ImageView imageViewBack = (ImageView) findViewById(R.id.iv_back_button);

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email_reg.getText().toString().isEmpty() || password_reg.getText().toString().isEmpty())
                {
                    Toast.makeText(regist_main.this, "Поля не заполнены", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mAuth.createUserWithEmailAndPassword(email_reg.getText().toString(), password_reg.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful())
                                    {
                                        Intent intent = new Intent(regist_main.this, news_main.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                }
            }
        });

        View.OnClickListener oclImageView = new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(regist_main.this, main.class);
                startActivity(intent);

            }
        };

        imageViewBack.setOnClickListener(oclImageView);
    }
}