package com.example.e1_t6_mob_2dam;

import java.util.Date;

import exceptions.ErrorWrongPassword;
import exceptions.ErrorUserNotFound;

public class Functions {

    public User searchUserDB (String userIn) throws ErrorUserNotFound {
        // Conexion a bd
        // Si no encuentra usuario con ese usuario -> Usuario null
        // Si lo encuentra devuelve el usuarui que sea
        Date d = new Date();
        User userDB = new User("a", "a", "a", "a", d, 123456789);
        //User userDB = null;
        if (userDB == null) {
            throw new ErrorUserNotFound();
        }

        return userDB;
    }

    public void checkLogin(String userIn, String passwordIn) throws ErrorWrongPassword, ErrorUserNotFound {
        User userDB = searchUserDB(userIn);
        if (!userDB.getErabiltzailea().toString().equals(userIn)){
            throw new ErrorWrongPassword();
        }
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
