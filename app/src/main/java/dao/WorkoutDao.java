package dao;

import android.util.Log;

import com.example.e1_t6_mob_2dam.ConectionDB;
import com.example.e1_t6_mob_2dam.GlobalVariables;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

import objects.User;
import objects.Workout;

public class WorkoutDao {
    private ConectionDB conectionDB = new ConectionDB();

    public ArrayList<Workout> getWorkouts(){
        ArrayList <Workout> workoutsDB = new ArrayList<Workout>();

        FirebaseFirestore db = conectionDB.getConnection();
        db.collection("workouts").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Workout workout = new Workout(
                            document.getString("izena"),
                            document.getString("video_url"),
                            document.getDouble("maila")
                    );
                    workoutsDB.add(workout);
                }
            } else {
                Log.d("casca", "casca");
            }
            Log.d("DBFinish", "finish" + GlobalVariables.usersDB.size());
        });
        GlobalVariables.workoutsDB = workoutsDB;
        return workoutsDB;
    }
}
