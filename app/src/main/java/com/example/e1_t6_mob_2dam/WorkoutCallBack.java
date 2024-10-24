// WorkoutCallBack.java
package com.example.e1_t6_mob_2dam;

import java.util.ArrayList;
import objects.Workout;

public interface WorkoutCallBack {
    void onWorkoutsRetrieved(ArrayList<Workout> workouts);
}
