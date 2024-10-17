package com.example.e1_t6_mob_2dam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.registerView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText nameIn = (EditText) findViewById(R.id.ptRegister_name);
        EditText surnameIn = (EditText) findViewById(R.id.ptRegister_surname);
        EditText userIn = (EditText) findViewById(R.id.ptRegister_user);
        EditText passwordIn = (EditText) findViewById(R.id.ptRegister_password);
        EditText password2In = (EditText) findViewById(R.id.ptRegister_password2);
        EditText dateIn = (EditText) findViewById(R.id.dtRegister_date);
        EditText emailIn = (EditText) findViewById(R.id.etRegister_email);
        EditText phoneIn = (EditText) findViewById(R.id.ptRegister_phone);
        Button btnRegister = (Button) findViewById(R.id.btnRegister_register);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}