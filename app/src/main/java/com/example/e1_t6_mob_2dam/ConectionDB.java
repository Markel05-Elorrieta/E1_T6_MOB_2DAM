package com.example.e1_t6_mob_2dam;


//import com.google.firebase.Firebase;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestoreSettings;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import objects.User;


public class ConectionDB {

    public FirebaseFirestore getConnection(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        return db;
    }

    public void closeConnection(FirebaseFirestore db){
        db.terminate();
    }

    public ArrayList<User> getUsers(){
        ArrayList <User> usersDBAux = new ArrayList<User>();

        FirebaseFirestore db = this.getConnection();
        db.collection("erabiltzaileak").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                int cont = 0;
                for (QueryDocumentSnapshot document : task.getResult()) {
                   User userDB = new User(
                            cont,
                            document.getString("izena"),
                            document.getString("abizenak"),
                            document.getString("erabiltzailea"),
                            document.getString("pasahitza"),
                            document.getDate("jaiotze_data"),
                            document.getString("email"),
                            document.getDouble("telefonoa").intValue(),
                            document.getDouble("maila").intValue()
                    );

                    usersDBAux.add(userDB);
                    cont++;
                }
            } else {
                Log.d("casca", "casca");
            }
            Log.d("DBFinish", "finish" + GlobalVariables.usersDB.size());
        });
        GlobalVariables.usersDB = usersDBAux;
        return usersDBAux;
    }

/*
    public void initializeDatabase() {
        System.out.println("inicio");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("erabiltzaileak")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        System.out.println("documentufuera");
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d("Firestore", document.getId() + " => " + document.getData());
                            User user = new User(
                                    document.getString("izena"),
                                    document.getString("abizenak"),
                                    document.getString("erabiltzailea"),
                                    document.getString("pasahitza"),
                                    document.getDate("jaiotze_data"),
                                    document.getString("email"),
                                    document.getDouble("telefonoa").intValue(),
                                    document.getDouble("maila").intValue()
                            );
                            Log.d("DBCon", user.getErabiltzailea());
                        }
                    } else {
                        System.out.println("erroresvarios");
                        Log.w("Firestore", "Error getting documents.", task.getException());
                    }
                });
        System.out.println("fin");
    }*/
}
