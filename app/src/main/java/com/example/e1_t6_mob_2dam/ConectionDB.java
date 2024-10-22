package com.example.e1_t6_mob_2dam;


//import com.google.firebase.Firebase;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestoreSettings;

import android.util.Log;

import com.google.firebase.firestore.FirebaseFirestore;



import com.google.firebase.firestore.QueryDocumentSnapshot;


import objects.User;


public class ConectionDB {
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
                                    document.getString("erabiltzailea"),
                                    document.getString("izena"),
                                    document.getString("abizenak"),
                                    document.getString("pasahitza"),
                                    document.getDate("jaiotze_data"),
                                    document.getString("email"),
                                    document.getDouble("telefonoa").intValue(),
                                    document.getDouble("maila").intValue()
                            );
                            Log.d("hola", user.getErabiltzailea());
                        }
                    } else {
                        System.out.println("erroresvarios");
                        Log.w("Firestore", "Error getting documents.", task.getException());
                    }
                });
        System.out.println("fin");
    }
}
