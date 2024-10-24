package com.example.e1_t6_mob_2dam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

import com.google.firebase.firestore.FirebaseFirestore;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.HashMap;

import CallBacks.UserCallBack;
import dao.UserDao;
import exceptions.ErrorWrongPassword;
import exceptions.PasswordDoNotMatch;
import exceptions.UserAlreadyExists;
import exceptions.UserNotFound;
import objects.User;


public class Functions {
    public static ArrayList<User> users = new ArrayList<>();
    private ConectionDB conectionDB = new ConectionDB();
    private User user;

    // Comprobar error
    public User searchUserDB (String userIn) throws UserNotFound {
        for (int i = 0; i < GlobalVariables.usersDB.size(); i++) {
            if (GlobalVariables.usersDB.get(i).getErabiltzailea().equals(userIn)) {
                 User userAux = GlobalVariables.usersDB.get(i);
                return userAux;
            }
        }
        throw new UserNotFound();
    }
/*
    public void checkLogin(String userIn, String passwordIn) throws ErrorWrongPassword, UserNotFound {
        User userDB = searchUserDB(userIn);
        if (!BCrypt.checkpw(passwordIn, userDB.getPasahitza())){
            throw new ErrorWrongPassword();
        } else {
            GlobalVariables.logedUser = userDB;
        }
    }
*/
    public void checkLogin(User userDB, String passwordIn) throws ErrorWrongPassword, UserNotFound {
       Log.d("pruebabasedatos", userDB.toString());
        if (userDB.getErabiltzailea() == null) {
            throw new UserNotFound();
        }
        else if (!BCrypt.checkpw(passwordIn, userDB.getPasahitza())) {
                throw new ErrorWrongPassword();
        } else {
            GlobalVariables.logedUser = userDB;
        }
    }

    public void checkRegister (String userIn, String passwordIn, String password2In) throws PasswordDoNotMatch, UserAlreadyExists {

        try {
            User userDB = searchUserDB(userIn);
            throw new UserAlreadyExists();
        } catch (UserNotFound e) {
            if (!passwordIn.equals(password2In)) {
                throw new PasswordDoNotMatch();
            }
            // comprobar fecha (falta!!)
        }
    }

    public void insertNewUser(User userNew){
        FirebaseFirestore db = conectionDB.getConnection();

        HashMap<String, Object> userNewHashMap = new HashMap<>();
        userNewHashMap.put("erabiltzailea", userNew.getErabiltzailea());
        userNewHashMap.put("izena", userNew.getIzena());
        userNewHashMap.put("abizenak", userNew.getAbizenak());
        userNewHashMap.put("pasahitza", BCrypt.hashpw(userNew.getPasahitza(), BCrypt.gensalt()));
        userNewHashMap.put("email", userNew.getEmail());
        userNewHashMap.put("maila", userNew.getMaila());
        userNewHashMap.put("telefonoa", userNew.getTelefonoa());
        userNewHashMap.put("jaiotze_data", userNew.getJaiotze_data());

        db.collection("erabiltzaileak").add(userNewHashMap).addOnSuccessListener(documentReference -> {
                    Log.d("Firestore", "DocumentSnapshot added with ID: " + documentReference.getId());
                })
                .addOnFailureListener(e -> {
                    Log.w("Firestore", "Error adding document", e);
                });

    }

    public void alertDisplay(AlertDialog.Builder builder, String title, String msg, String msgBtn){
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(msgBtn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    /*
    ConectionDB conection = new ConectionDB();
    public boolean checkLoginDB(String userIn, String passwordIn, AlertDialog.Builder builder) throws Exception, ErrorPasahitzaTxarto, ErrorUserNotFound {
        Log.d("MainActivity", "Este es un mensaje de debug");
        FirebaseFirestore db = conection.getConnection();

        db.collection("usuarios").whereEqualTo("erabiltzailea", userIn)
                .get().addOnSuccessListener(queryDocumentSnapshots -> {
                    List<DocumentSnapshot> userDB = queryDocumentSnapshots.getDocuments();
                    if (userDB.isEmpty()){

                        builder.setTitle("Login txarto");
                        builder.setMessage("Login error empty");
                        builder.setPositiveButton("Berriro sahiatu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();

                        return;
                    }

                    String passwordDB = userDB.get(0).getString("pasahitza");
                    String toDelete = "$2a$10$cf6rk5UVQldMoOtWMvx8TuhPplfr2BIoYCaEeTqiI74BOfNBfWkW6";

                    if (!passwordDB.equals(toDelete)){
                        builder.setTitle("Login txarto");
                        builder.setMessage("Login error psw");
                        builder.setPositiveButton("Berriro sahiatu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();

                        return;
                    }
                });

        conection.closeConnection(db);
        return true;
    }
    */
}
