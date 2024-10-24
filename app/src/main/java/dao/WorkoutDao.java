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
    private int ariketakCount = 0;
    public ArrayList<Workout> getWorkouts(){
        ArrayList <Workout> workoutsDB = new ArrayList<Workout>();


        FirebaseFirestore db = conectionDB.getConnection();
        db.collection("workouts").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    this.ariketakCount = 0;
                    db.collection("workouts").document(document.getId()).collection("ariketak").get()
                            .addOnCompleteListener(ariketakTask -> {
                                if (ariketakTask.isSuccessful()) {
                                    if (document.getDouble("maila") <= GlobalVariables.logedUser.getMaila()) {
                                        Workout workout = new Workout();
                                        workout.setIzena(document.getString("izena"));
                                        workout.setMaila(document.getDouble("maila"));
                                        workout.setVideoURL(document.getString("video_url"));
                                        workout.setAriketaCount(ariketakTask.getResult().size());
                                        workoutsDB.add(workout);
                                        Log.d("AriketakCount", workout.toString());
                                    }
                                } else {
                                }
                            });

/*
                    Workout workout = new Workout(
                            document.getString("izena"),
                            document.getDouble("maila"),
                            document.getString("video_url"),
                            this.ariketakCount
                    );
 */             }
            } else {
                Log.d("casca", "casca");
            }
            Log.d("DBFinish", "finish" + GlobalVariables.workoutsDB.size());
        });
        GlobalVariables.workoutsDB = workoutsDB;
        return workoutsDB;
    }
}
