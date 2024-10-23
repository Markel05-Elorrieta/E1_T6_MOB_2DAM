package com.example.e1_t6_mob_2dam;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import objects.Workout;

public class AdapterWorkoutList extends RecyclerView.Adapter<AdapterWorkoutList.ViewHolder> {
    private Context context;
    private List<Workout> workouts; // Updated to handle Workout objects

    // Updated constructor for Workout list
    public AdapterWorkoutList(Context context, List<Workout> workouts) {
        this.context = context;
        this.workouts = workouts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the custom layout for each item in the list
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workoutlistformat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the Workout object based on position
        Workout workout = workouts.get(position);

        // Set item views based on the data in the Workout object
        holder.tvIzena.setText(workout.getIzena());
        holder.tvMaila.setText("Level: " + String.valueOf(workout.getMaila()));

        // Set an OnClickListener for the entire item view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the workout video URL when clicked
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(workout.getVideoURL()));
                context.startActivity(intent);
            }
        });

        // You can also set listeners for individual views like below:
        holder.tvIzena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display a toast with the workout name
                Toast.makeText(context, "Workout: " + workout.getIzena(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.tvMaila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display a toast with the workout difficulty level
                Toast.makeText(context, "Level: " + workout.getMaila(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return workouts.size(); // Return the size of the Workout list
    }

    // ViewHolder class holds the item layout views for Workout
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvIzena;  // Workout name (izena)
        public TextView tvMaila;  // Workout difficulty level (maila)

        public ViewHolder(View itemView) {
            super(itemView);
            tvIzena = itemView.findViewById(R.id.tvList_name); // Update with actual TextView IDs
            tvMaila = itemView.findViewById(R.id.tvList_maila);
        }
    }
}
