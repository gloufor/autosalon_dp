package com.example.autosalon_bashkirov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class main extends AppCompatActivity {

    private EditText email_login;
    private EditText password_login;
    private Button buttonAuth;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewReg = (TextView) findViewById(R.id.create_acc);
        email_login = findViewById(R.id.email_login);
        password_login = findViewById(R.id.password_login);
        buttonAuth = findViewById(R.id.buttonAuth);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();



        View.OnClickListener oclTextViewReg = new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(main.this, regist_main.class);
                startActivity(intent);
            }
        };

        buttonAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email_login.getText().toString().isEmpty() || password_login.getText().toString().isEmpty()){
                    Toast.makeText(main.this, "Поля не заполнены", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.signInWithEmailAndPassword(email_login.getText().toString(), password_login.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(main.this, news_main.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(main.this, "Произошла ошибка", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        textViewReg.setOnClickListener(oclTextViewReg);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),news_main.class));
            finish();
        }
    }

}