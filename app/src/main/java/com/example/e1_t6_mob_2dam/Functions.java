package com.example.e1_t6_mob_2dam;

import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.Date;

import exceptions.ErrorWrongPassword;
import exceptions.PasswordDoNotMatch;
import exceptions.UserAlreadyExists;
import exceptions.UserNotFound;

public class Functions {
    public static ArrayList<User> users = new ArrayList<>();
    public User searchUserDB (String userIn) throws UserNotFound {
        // Conexion a bd
        // Si no encuentra usuario con ese usuario -> Usuario null
        // Si lo encuentra devuelve el usuarui que sea
        Date d = new Date();
        User userDB = new User("a", "a", "a", "a", d, "a" ,123456789);
        users.add(userDB);
        userDB = new User("b", "b", "b", "b", d, "b" ,123456789);;
        users.add(userDB);

        for (User user : users) {
            if (user.getErabiltzailea().equals(userIn)){
                return user;
            }
        }

        throw new UserNotFound();
        /*
        if (userDB == null) {
            throw new UserNotFound();
        }*/
    }

    public void checkLogin(String userIn, String passwordIn) throws ErrorWrongPassword, UserNotFound {
        User userDB = searchUserDB(userIn);

        if (!userDB.getPasahitza().toString().equals(passwordIn)){
            throw new ErrorWrongPassword();
        } else {
            // Guardar user en global!!!
        }
    }

    public void checkRegister (String userIn, String passwordIn, String password2In) throws PasswordDoNotMatch, UserAlreadyExists {

        try {
            // Si encuentra usuario, me suelta exception de que el usuario existe
            User userDB = searchUserDB(userIn);
            throw new UserAlreadyExists();
        } catch (UserNotFound e) {
            // Si no encuentra usuario, hara las demas comprobaciones

            // comprobar psw con psw2
            if (!passwordIn.equals(password2In)) {
                throw new PasswordDoNotMatch();
            }

            // comprobar fecha (falta!!)
        }
    }

    public void insertNewUser(User userNew){
        users.add(userNew);
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
