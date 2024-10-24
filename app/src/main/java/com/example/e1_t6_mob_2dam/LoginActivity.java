package com.example.e1_t6_mob_2dam;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dao.UserDao;
import dao.WorkoutDao;
import exceptions.ErrorWrongPassword;
import exceptions.UserNotFound;
import objects.Cache;
import objects.Workout;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loginView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        UserDao userDao = new UserDao();
        userDao.getUsers();

        Button btnLogin = (Button) findViewById(R.id.btnLogin_login);
        Button btnRegister = (Button) findViewById(R.id.btnLogin_register);
        EditText userIn = (EditText) findViewById(R.id.ptLogin_user);
        EditText passwordIn = (EditText) findViewById(R.id.ptLogin_password);
        CheckBox rememberIn = findViewById(R.id.cbLogin_remember);
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

        Functions functions = new Functions();
        Cache cache = new Cache();
        WorkoutDao workoutDao = new WorkoutDao();
        workoutDao.getWorkouts();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    functions.checkLogin(userIn.getText().toString(), passwordIn.getText().toString());

                    if (rememberIn.isChecked()){
                        Log.d("entro", "entro");
                        cache.put("rememberUser", GlobalVariables.logedUser.getErabiltzailea());
                    }

                    Intent intent = new Intent(LoginActivity.this, WorkoutsActivity.class);
                    startActivity(intent);
                    finish();

                } catch (UserNotFound errorUserNotFound) {
                    functions.alertDisplay(builder, "Login txarto", errorUserNotFound.getMessage(), "Berriro sahiatu");
                } catch (ErrorWrongPassword errorWrongPassword) {
                    functions.alertDisplay(builder, "Login txarto", errorWrongPassword.getMessage(), "Berriro sahiatu");
                }
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}