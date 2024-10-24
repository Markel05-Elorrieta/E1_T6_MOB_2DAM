package com.example.e1_t6_mob_2dam;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WorkoutInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_workout_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView txtWorkoutName = (TextView) findViewById(R.id.tvWorkoutName);
        TextView txtWorkoutMaila = (TextView) findViewById(R.id.tvWorkoutMaila);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Functions functions = new Functions();
        Button btnAtzera = (Button) findViewById(R.id.btnWorkoutInfo_back);
        btnAtzera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutInfoActivity.this, WorkoutsActivity.class);
                startActivity(intent);
                finish();

            }
        });

        txtWorkoutName.setText(GlobalVariables.currentWorkout.getIzena());
        txtWorkoutMaila.setText("Maila: " + GlobalVariables.currentWorkout.getMaila());


    }
}