package com.example.e1_t6_mob_2dam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import exceptions.ErrorUserNotFound;
import exceptions.ErrorWrongPassword;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Functions functions = new Functions();

        Button btnLogin = (Button) findViewById(R.id.btnLogin_login);
        Button btnRegister = (Button) findViewById(R.id.btnLogin_register);
        EditText userIn = (EditText) findViewById(R.id.ptLogin_user);
        EditText passwordIn = (EditText) findViewById(R.id.ptLogin_password);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //try {
                try {
                    functions.checkLogin(userIn.getText().toString(), passwordIn.getText().toString());
                } catch (ErrorUserNotFound errorUserNotFound) {
                    builder.setTitle("Login txarto");
                    builder.setMessage(errorUserNotFound.getMessage());
                    builder.setPositiveButton("Berriro sahiatu", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } catch (ErrorWrongPassword errorWrongPassword) {
                    builder.setTitle("Login txarto");
                    builder.setMessage(errorWrongPassword.getMessage());
                    builder.setPositiveButton("Berriro sahiatu", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}