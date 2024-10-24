package dao;

import android.util.Log;

import com.example.e1_t6_mob_2dam.ConectionDB;
import com.example.e1_t6_mob_2dam.GlobalVariables;
import CallBacks.UserCallBack;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import objects.User;

public class UserDao {
    private ConectionDB conectionDB = new ConectionDB();

    public void searchUserDBByUser(String userIn, UserCallBack userCallBack){
        FirebaseFirestore db = conectionDB.getConnection();

        db.collection("erabiltzaileak").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                AtomicInteger completedTasks = new AtomicInteger(0);
                int totalTasks = task.getResult().size();

                for (QueryDocumentSnapshot document : task.getResult()) {
                    if (document.getString("erabiltzailea").equals(userIn)){
                        User userDB = new User(
                                completedTasks.get(),
                                document.getString("izena"),
                                document.getString("abizenak"),
                                document.getString("erabiltzailea"),
                                document.getString("pasahitza"),
                                document.getDate("jaiotze_data"),
                                document.getString("email"),
                                document.getDouble("telefonoa").intValue(),
                                document.getDouble("maila").intValue()
                        );
                        userCallBack.userRetrieved(userDB);
                        break;
                    }
                    if (completedTasks.incrementAndGet() == totalTasks) {
                        User userDB = new User();
                        userCallBack.userRetrieved(userDB);
                    }
                }
            } else {
                User userDB = new User();
                userCallBack.userRetrieved(userDB);
            }
        });
    }
}
