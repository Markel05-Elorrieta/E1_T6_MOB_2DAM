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
}
