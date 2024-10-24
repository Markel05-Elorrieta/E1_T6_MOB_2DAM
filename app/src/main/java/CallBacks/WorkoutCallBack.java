// WorkoutCallBack.java
package CallBacks;

import java.util.ArrayList;
import objects.Workout;

public interface WorkoutCallBack {
    void onWorkoutsRetrieved(ArrayList<Workout> workouts);
}
